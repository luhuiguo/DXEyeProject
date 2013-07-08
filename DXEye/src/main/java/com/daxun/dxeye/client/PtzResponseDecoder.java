package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

/**
 * Created by luhuiguo on 13-7-7.
 */
public class PtzResponseDecoder extends SNVRMessageDecoder {

    //private static final Logger LOGGER = LoggerFactory.getLogger(PtzResponseDecoder.class);

    public PtzResponseDecoder() {
        super(SNVRMessage.CMD_PTZ_RESPONSE);
    }

    @Override
    protected SNVRMessage decodeBody(IoSession session, IoBuffer in) throws Exception {

        PtzResponse m=new PtzResponse();

        m.setStatus(in.getInt());

        return m;
    }


}