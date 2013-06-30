package com.daxun.dxeye.client;

/**
 * Created by luhuiguo on 13-6-29.
 */
public class LoginResponse extends SNVRMessage {

    private int status;

    private String token;

    private String userInfo;

    public LoginResponse() {
        super(CMD_LOGIN_RESPONSE);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
