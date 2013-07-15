package com.daxun.dxeye;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.daxun.dxeye.client.Channel;
import com.daxun.dxeye.client.SNVRClient;

import java.util.List;


public class MainActivity extends Activity {

    private GridView gridView;

    private List<Channel> channels;



    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridView);



        gridView.setAdapter(new ChannelAdapter(this,SNVRClient.getInstance().getChannels()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Channel c = (Channel)adapterView.getItemAtPosition(i);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PreviewActivity.class);
                intent.putExtra(Constants.CHANNEL_KEY,c);

                startActivity(intent);


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:

                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle(R.string.logout)
                        .setMessage(R.string.confirm_logout)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LogoutTask task = new LogoutTask();
                                task.execute();
                            }

                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();
                return true;

            case R.id.action_channel:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ChannelActivity.class);
                //intent.putExtra(Constants.CHANNEL_KEY,c);

                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), R.string.confirm_exit,
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            LogoutTask task = new LogoutTask();
            task.execute();
            finish();
            System.exit(0);
        }
    }


    class LogoutTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            SNVRClient client = SNVRClient.getInstance();

            client.logout();

            return Boolean.TRUE;

        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);


            Intent intent = new Intent();
            intent.setClass(MainActivity.this, LoginActivity.class);

            startActivity(intent);

            MainActivity.this.finish();


        }


    }

}
