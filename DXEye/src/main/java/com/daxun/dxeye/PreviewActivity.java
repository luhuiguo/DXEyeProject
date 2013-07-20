package com.daxun.dxeye;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.daxun.dxeye.client.Channel;
import com.daxun.dxeye.client.SNVRClient;

import org.apache.mina.core.session.IoSession;

import java.util.List;

/**
 * Created by luhuiguo on 13-6-28.
 */
public class PreviewActivity extends Activity {

    private static final String TAG = ChannelActivity.class.getSimpleName();

    private Channel channel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        channel = (Channel) getIntent().getSerializableExtra(Constants.CHANNEL_KEY);

        setTitle(channel.getName());

        PreviewTask task = new PreviewTask();
        task.execute();


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }


    class PreviewTask extends AsyncTask<Void, Void, IoSession> {

        @Override
        protected IoSession doInBackground(Void... params) {

            SNVRClient client = SNVRClient.getInstance();
            IoSession session = client.preview((short) channel.getId(), 1);


            return session;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(IoSession result) {


        }


    }
}