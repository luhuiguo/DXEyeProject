package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

/**
 * Created by luhuiguo on 13-6-29.
 */
public class LoginRequestEncoder extends SNVRMessageEncoder<LoginRequest>{
    @Override
    protected void encodeBody(IoSession session, LoginRequest message, IoBuffer out) throws Exception {

        out.putString(message.getUsername(),SNVRMessage.USERNAME_LEN,UTF8_ENCODER);
        out.putString(message.getPassword(),SNVRMessage.PASSWORD_LEN,UTF8_ENCODER);
        out.putString(message.getReserved(),SNVRMessage.RESERVED_LEN,UTF8_ENCODER);


    }
}
