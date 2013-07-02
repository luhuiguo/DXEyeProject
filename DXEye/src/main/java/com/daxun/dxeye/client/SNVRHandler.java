package com.daxun.dxeye.client;


import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by luhuiguo on 13-6-29.
 */
public class SNVRHandler extends IoHandlerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SNVRHandler.class);

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {

        LOGGER.warn("exceptionCaught",cause);
        super.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        LOGGER.debug("messageReceived: {}",message);
        super.messageReceived(session, message);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        LOGGER.debug("messageSent: {}",message);
        super.messageSent(session, message);
    }
}
