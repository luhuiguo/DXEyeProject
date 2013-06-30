package com.daxun.dxeye.client;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by luhuiguo on 13-6-29.
 */
public class LoginResponseDecoder extends SNVRMessageDecoder {

    public LoginResponseDecoder() {
        super(SNVRMessage.CMD_LOGIN_RESPONSE);
    }

    @Override
    protected SNVRMessage decodeBody(IoSession session, IoBuffer in) throws Exception {

        LoginResponse m=new LoginResponse();


        m.setStatus(in.getInt());
        m.setToken(in.getString(SNVRMessage.TOKEN_LEN,UTF8_DECODER));
        m.setUserInfo(in.getString(SNVRMessage.USERINFO_LEN,UTF8_DECODER));

        return m;
    }


}
