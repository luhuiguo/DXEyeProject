package com.daxun.dxeye.client;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by luhuiguo on 13-6-28.
 */
public class SNVRClient {

    public static final long TIMEOUT = 10 * 1000L;

    private static SNVRClient sharedInstance;

    private String host;

    private int port;

    private String token;

    private NioSocketConnector connector;



    public static SNVRClient getSharedInstance() {
        if (sharedInstance == null) {
            synchronized (SNVRClient.class) {
                if (sharedInstance == null) {
                    sharedInstance = new SNVRClient();
                }
            }
        }
        return sharedInstance;
    }

    public SNVRClient() {

        connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(TIMEOUT);

        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new SNVRCodecFactory()));
        connector.getFilterChain().addLast("logger", new LoggingFilter());

        connector.setHandler(new SNVRHandler());



    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean login(String username,String password){

        boolean ret = false;

        try {

            ConnectFuture future = connector.connect(new InetSocketAddress(host, port));
            future.awaitUninterruptibly();
            if (!future.isConnected()) {
                return false;
            }
            IoSession session = future.getSession();


            session.write(new LoginRequest(username,password)).awaitUninterruptibly();

            ReadFuture readFuture = session.read();

            if (readFuture.awaitUninterruptibly(TIMEOUT,TimeUnit.MILLISECONDS)) {
                LoginResponse message = (LoginResponse) readFuture.getMessage();

                if (0 == message.getStatus()){
                    ret = true;
                    token = message.getToken();
                }else{
                    ret = false;
                }

            } else {
                ret = false;

            }



            session.close(true);
            session.getService().dispose();


        }catch (Exception e) {
            return false;
        }



        return ret;


    }



}
