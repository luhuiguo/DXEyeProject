package com.daxun.dxeye.client;

/**
 * Created by luhuiguo on 13-7-3.
 */
public class PtzResponse extends SNVRMessage {
    private int status;


    public PtzResponse() {
        super(CMD_PTZ_RESPONSE);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PtzResponse{" +
                "size=" + size +
                ", type=" + Integer.toHexString(type) +
                ", status=" + status +
                '}';
    }

}

