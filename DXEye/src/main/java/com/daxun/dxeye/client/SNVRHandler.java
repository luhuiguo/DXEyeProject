package com.daxun.dxeye.client;

import android.util.Log;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by luhuiguo on 13-6-29.
 */
public class SNVRHandler extends IoHandlerAdapter {

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {

        Log.d(this.getClass().getSimpleName(),cause.getLocalizedMessage(),cause);
        super.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        super.messageReceived(session, message);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        Log.d(this.getClass().getSimpleName(),message.toString());
        super.messageSent(session, message);
    }
}
