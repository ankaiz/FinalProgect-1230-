package com.example.qqq.finalproject1230;

/**
 * Created by qqq on 2015/12/28.
 */
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class finish extends ActionBarActivity {

    DatagramPacket sendPkg;
    DatagramSocket ds = null;
    TextView tv;
    Button bt_sure;
    int value;
    int set;
    int set_coll;
    int id = 912345678;
    int which;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);
        tv = (TextView) findViewById(R.id.price);
        bt_sure = (Button) findViewById(R.id.bt_sure);
        Intent i = this.getIntent();
        Bundle b = i.getExtras();
        value = b.getInt("price");
        set = b.getInt("set");
        set_coll = b.getInt("set_coll");
        which = b.getInt("which");
        tv.setText("總共是：" + String.valueOf(value) + "元");

        bt_sure.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                send_order();

            }//onClick
        });//bt_alacarte

    }//onCreate


    public void send_order()  {
     final    Toast toast = Toast.makeText(this ,"點餐成功" , Toast.LENGTH_SHORT);
        Thread background = new Thread(new Runnable() {
            public void run() {
                InetAddress inet;
                try {
                    ds = new DatagramSocket();
                    inet = InetAddress.getByName("192.168.43.255");
                    JSONObject jsonRoot = new JSONObject();
                    try {
                        if(which == 1) {
                            jsonRoot.put("price", value);
                            jsonRoot.put("set", set);
                            jsonRoot.put("set_coll", set_coll);
                            jsonRoot.put("id", id);
                            jsonRoot.put("which", which);
                            sendPkg = new DatagramPacket(jsonRoot.toString().getBytes(),
                                    jsonRoot.toString().getBytes().length, inet, 5555);
                            ds.send(sendPkg);
                            ds.close();
                            toast.show();
                        }//if
                        else if(which == 0){
                            jsonRoot.put("which", which);
                            jsonRoot.put("price", value);
                            jsonRoot.put("set", set);
                            jsonRoot.put("id", id);
                            sendPkg = new DatagramPacket(jsonRoot.toString().getBytes(),
                                    jsonRoot.toString().getBytes().length, inet, 5555);
                            ds.send(sendPkg);
                            ds.close();
                            toast.show();
                        }//else if
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (UnknownHostException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            }
        });
        background.start();
    }//send_order
}//finish