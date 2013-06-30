package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by luhuiguo on 13-6-29.
 */
public abstract class SNVRMessageEncoder<T extends SNVRMessage> implements MessageEncoder<T> {

    public static final CharsetEncoder UTF8_ENCODER = Charset.forName("UTF-8").newEncoder();


    @Override
    public void encode(IoSession session, T message, ProtocolEncoderOutput out) throws Exception {

        IoBuffer buf= IoBuffer.allocate(SNVRMessage.HEADER_LEN);
        buf.setAutoExpand(true);

        buf.putInt(message.getSize());
        buf.putInt(message.getType());
        buf.putInt(message.getNetwork());
        buf.putInt(message.getSource());
        buf.putInt(message.getTarget());

        encodeBody(session, message, buf);
        buf.flip();
        out.write(buf);
    }

    protected abstract void encodeBody(IoSession session ,T message ,IoBuffer out) throws Exception;





}
