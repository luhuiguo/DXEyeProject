package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

/**
 * Created by luhuiguo on 13-7-7.
 */
public class PreviewRequestEncoder  extends SNVRMessageEncoder<PreviewRequest>{
    @Override
    protected void encodeBody(IoSession session, PreviewRequest message, IoBuffer out) throws Exception {
        out.putString(message.getToken(),SNVRMessage.TOKEN_LEN,UTF8_ENCODER);
        out.putLong(message.getDevice());
        out.putShort(message.getChannel());
        out.putInt(message.getStream());
    }
}