package com.daxun.dxeye.client;


import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;

/**
 * Created by luhuiguo on 13-6-29.
 */
public class SNVRCodecFactory extends DemuxingProtocolCodecFactory {
    public SNVRCodecFactory() {
        super.addMessageEncoder(LoginRequest.class, LoginRequestEncoder.class);

        super.addMessageDecoder(LoginResponseDecoder.class);

    }
}
