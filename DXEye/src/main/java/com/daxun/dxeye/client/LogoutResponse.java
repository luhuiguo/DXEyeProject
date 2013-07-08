package com.daxun.dxeye.client;

/**
 * Created by luhuiguo on 13-7-3.
 */
public class LogoutResponse extends SNVRMessage {

    public LogoutResponse() {
        super(CMD_LOGOUT_RESPONSE);
    }

    @Override
    public String toString() {
        return "LogoutResponse{" +
                "size=" + size +
                ", type=" + Integer.toHexString(type) +
                '}';
    }

}
