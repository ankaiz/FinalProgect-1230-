package com.example.qqq.finalproject1230;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_set = (Button)findViewById(R.id.bt_set);
        Button bt_alacarte = (Button)findViewById(R.id.bt_alacarte);
        bt_set.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, set.class);
                startActivity(i);
            }//onClick
        });//bt_set

        bt_alacarte.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, alacarte.class);
                startActivity(i);
            }//onClick
        });//bt_alacarte

    }

}
