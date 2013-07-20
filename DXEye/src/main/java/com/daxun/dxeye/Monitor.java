package com.daxun.dxeye;

import com.daxun.dxeye.client.Channel;
import com.daxun.dxeye.client.PreviewHandler;
import com.daxun.dxeye.client.SNVRCodecFactory;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * Created by luhuiguo on 13-7-19.
 */
public class Monitor {

    private Channel channel;

    public Monitor(Channel channel) {

        this.channel = channel;
    }

    public void play(int Stream){
//        NioSocketConnector connector = new NioSocketConnector();
//        connector.setConnectTimeoutMillis(TIMEOUT);
//
//        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new SNVRCodecFactory()));
//        connector.getFilterChain().addLast("logger", new LoggingFilter());
//        connector.setHandler(new PreviewHandler());
//
//        LOGGER.debug("Connectting to {}:{}",host,port);
//
//        IoSession session = connector.connect(new InetSocketAddress(host, port)).awaitUninterruptibly().getSession();

    }

    public void stop(){

    }

}
