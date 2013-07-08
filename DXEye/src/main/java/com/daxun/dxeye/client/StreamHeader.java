package com.daxun.dxeye.client;

/**
 * Created by luhuiguo on 13-7-7.
 */
public class StreamHeader {

    private int  size;
    private int  magic1;
    private int  magic2;
    private int  length;
    private int  width;
    private int  height;
    private byte  streamType;
    private byte subStreamType;
    private byte frameType;
//    private byte reserved;
//    private byte reserved1[2];
    private byte audioChannelCount;
    private byte audioBits;
    private int timeStamp1;
    private int timeStamp2;
    private int audioSamples;
//    private int reserved2;
    private byte OSDLineCount;
    private byte OSDLineWidth;
//    private byte reserved3[14];





}
