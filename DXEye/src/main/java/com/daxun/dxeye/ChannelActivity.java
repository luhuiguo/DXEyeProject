package com.daxun.dxeye;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.daxun.dxeye.client.Channel;
import com.daxun.dxeye.client.SNVRClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luhuiguo on 13-6-28.
 */
public class ChannelActivity extends ListActivity {

    //private ListView listView;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_channel);
//
//        listView = (ListView) findViewById(R.id.listView);


        SimpleAdapter adapter = new SimpleAdapter(this, getData(), android.R.layout.simple_list_item_multiple_choice,new String[] {"name"}, new int[] {android.R.id.text1});

        setListAdapter(adapter);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


//
//        this.setListAdapter();
//
//
//        SimpleAdapter channelAdapter = new SimpleAdapter(this, SNVRClient.getInstance().channel(),R.layout. );
//
//        listView.setAdapter(channelAdapter);


    }


    public List<Map<String,String>> getData(){

        List<Map<String,String>> list = new ArrayList<Map<String,String>>();

        for (Channel ch:SNVRClient.getInstance().getChannels()){
            Map<String,String> map = new HashMap<String, String>();
            map.put("id",String.valueOf(ch.getId()));
            map.put("name",ch.getName());
            list.add(map);

        }



        return list;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.channel, menu);
        return true;
    }

}