package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import java.io.ByteArrayInputStream;
import java.nio.ByteOrder;

/**
 * Created by luhuiguo on 13-7-7.
 */
public class PreviewDataDecoder extends SNVRMessageDecoder {

    //private static final Logger LOGGER = LoggerFactory.getLogger(PreviewResponseDecoder.class);

    public PreviewDataDecoder() {
        super(SNVRMessage.CMD_PREVIEW_DATA);
    }

    @Override
    protected SNVRMessage decodeBody(IoSession session, IoBuffer in) throws Exception {



        PreviewData m=new PreviewData();


        m.setType(in.getInt());
        m.setSize(in.getInt());


        Payload p = new Payload();
        in.order(ByteOrder.LITTLE_ENDIAN);
        p.setSize(in.getInt());

        p.setMagic1(in.getInt());

        p.setMagic2(in.getInt());
        p.setLength(in.getInt());
        p.setWidth(in.getInt());
        p.setHeight(in.getInt());
        p.setStreamType(in.get());
        p.setSubStreamType(in.get());
        p.setFrameType(in.get());

        in.get(); //reserved
        in.get(); //reserved1
        in.get(); //reserved1

        p.setAudioChannelCount(in.get());

        p.setAudioBits(in.get());





        m.setPayload(p);








        return m;
    }


}