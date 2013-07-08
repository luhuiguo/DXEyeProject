package com.daxun.dxeye.client;

/**
 * Created by luhuiguo on 13-7-3.
 */
public class ChannelRequest extends SNVRMessage {

    private String token;


    public ChannelRequest() {
        super(CHANNEL_REQUEST_LEN, CMD_CHANNEL_REQUEST);
    }

    public ChannelRequest(String token) {
        super(CHANNEL_REQUEST_LEN, CMD_CHANNEL_REQUEST);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ChannelRequest{" +
                "size=" + size +
                ", type=" + Integer.toHexString(type) +
                ", token='" + token + '\'' +
                '}';
    }
}
