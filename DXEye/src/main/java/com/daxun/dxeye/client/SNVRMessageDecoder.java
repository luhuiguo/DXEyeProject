package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by luhuiguo on 13-6-29.
 */
public abstract class SNVRMessageDecoder implements MessageDecoder {

    public static final CharsetDecoder UTF8_DECODER = Charset.forName("UTF-8").newDecoder();

    private int size;

    private final int type;

    private int network;

    private int source;

    private int target;

    private boolean readHeader;

    protected SNVRMessageDecoder(int type){
        this.type=type;
    }

    @Override
    public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
        if(in.remaining()<SNVRMessage.HEADER_LEN){
            return MessageDecoderResult.NEED_DATA;
        }

        size = in.getInt();

        if(type==in.getShort())
        {
            return  MessageDecoderResult.OK;
        }
        return MessageDecoderResult.NOT_OK;


    }

    @Override
    public MessageDecoderResult decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        if(!readHeader){
            network = in.getInt();
            source=in.getInt();
            target=in.getInt();
            readHeader=true;
        }

        if (in.remaining() < size -SNVRMessage.HEADER_LEN){
            return  MessageDecoderResult.NEED_DATA;
        }

        SNVRMessage m=decodeBody(session, in);

        if(m==null)
        {
            return  MessageDecoderResult.NEED_DATA;
        }else{
            readHeader=false;
        }
        m.setSize(size);
        m.setNetwork(network);
        m.setSource(source);
        m.setTarget(target);
        out.write(m);
        return MessageDecoderResult.OK;
    }

    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {

    }

    protected abstract SNVRMessage decodeBody(IoSession session ,IoBuffer in) throws Exception;
}
