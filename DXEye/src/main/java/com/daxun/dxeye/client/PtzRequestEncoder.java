package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

/**
 * Created by luhuiguo on 13-7-7.
 */
public class PtzRequestEncoder extends SNVRMessageEncoder<PtzRequest>{
    @Override
    protected void encodeBody(IoSession session, PtzRequest message, IoBuffer out) throws Exception {
        out.putString(message.getToken(),SNVRMessage.TOKEN_LEN,UTF8_ENCODER);
        out.putLong(message.getDevice());
        out.putShort(message.getChannel());
        out.put(message.getCommand());
        out.put(message.getOption());
    }
}