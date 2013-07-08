package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by luhuiguo on 13-7-7.
 */
public class LogoutResponseDecoder extends SNVRMessageDecoder {

    //private static final Logger LOGGER = LoggerFactory.getLogger(LogoutResponseDecoder.class);

    public LogoutResponseDecoder() {
        super(SNVRMessage.CMD_LOGOUT_RESPONSE);
    }

    @Override
    protected SNVRMessage decodeBody(IoSession session, IoBuffer in) throws Exception {

        LogoutResponse m=new LogoutResponse();

        return m;
    }
}