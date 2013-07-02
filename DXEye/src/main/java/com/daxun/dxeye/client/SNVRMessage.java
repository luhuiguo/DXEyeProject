package com.daxun.dxeye.client;

/**
 * Created by luhuiguo on 13-6-29.
 */
public abstract class SNVRMessage {

    public static final int HEADER_LEN = 20;

    public static final int USERNAME_LEN = 20;
    public static final int PASSWORD_LEN = 40;
    public static final int VERSION_LEN = 4;
    public static final int RESERVED_LEN = 24;

    public static final int LOGIN_REQUEST_LEN = HEADER_LEN + USERNAME_LEN + PASSWORD_LEN + VERSION_LEN + RESERVED_LEN;


    public static final int TOKEN_LEN = 128;
    public static final int USERINFO_LEN = 128;


    public static final int CMD_LOGIN_REQUEST = 0x00010001;
    public static final int CMD_LOGIN_RESPONSE = 0x80010001;
    public static final int CMD_LOGOUT_REQUEST = 0x00010003;
    public static final int CMD_LOGOUT_RESPONSE = 0x80010003;
    public static final int CMD_CHANNEL_REQUEST = 0x00010004;
    public static final int CMD_CHANNEL_RESPONSE = 0x80010004;
    public static final int CMD_PREVIEW_REQUEST = 0x00050101;
    public static final int CMD_PREVIEW_RESPONSE = 0x80050101;
    public static final int CMD_PREVIEW_TRANSFER = 0x80050102;
    public static final int CMD_PTZ_REQUEST = 0x00090002;
    public static final int CMD_PTZ_RESPONSE = 0x80090001;


    protected int size;

    protected int type;

    protected int network;

    protected int source;

    protected int target;


    protected SNVRMessage(int type) {
        this.type = type;
    }

    protected SNVRMessage(int size, int type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNetwork() {
        return network;
    }

    public void setNetwork(int network) {
        this.network = network;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "SNVRMessage{" +
                "size=" + size +
                ", type=" + type +
                ", network=" + network +
                ", source=" + source +
                ", target=" + target +
                '}';
    }
}
