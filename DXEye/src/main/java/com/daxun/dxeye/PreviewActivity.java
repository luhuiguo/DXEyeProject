package com.daxun.dxeye;

import android.app.Activity;
import android.os.Bundle;

import com.daxun.dxeye.client.Channel;

/**
 * Created by luhuiguo on 13-6-28.
 */
public class PreviewActivity extends Activity {

    private Channel channel;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        channel = (Channel)getIntent().getSerializableExtra(Constants.CHANNEL_KEY);

        setTitle(channel.getName());
    }
}