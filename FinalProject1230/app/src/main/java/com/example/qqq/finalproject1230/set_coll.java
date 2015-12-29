package com.example.qqq.finalproject1230;

/**
 * Created by qqq on 2015/12/23.
 */
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.content.Intent;

public class set_coll extends ActionBarActivity {
    ListView lv_coll;
    int value;
    int set;
    int set_coll;
    int[] collIds = new int[]{
                             R.drawable.a,
                             R.drawable.b,
                             R.drawable.c,
                             R.drawable.d,
                            };
    String[] colls= new String[]{"經典配餐","清爽配餐","酷炫配餐","勁脆配餐"};
    String[] price = { "30元","40元","50元","60元"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_collocation);

        lv_coll = (ListView)findViewById(R.id.lv_coll);
        MyAdapter adapter=new MyAdapter(this);
        lv_coll.setAdapter(adapter);
        lv_coll.setOnItemClickListener(gotofinish);
        Intent i = this.getIntent();
        Bundle b = i.getExtras();
        value = b.getInt("price");
        set = b.getInt("set");
    }//onCreate
    private ListView.OnItemClickListener gotofinish=
            new ListView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   if(parent.getItemAtPosition(position).toString().equals("經典配餐")){
                        value += 30;
                        set_coll= 0;
                    }//if equals 經典套餐
                   else if(parent.getItemAtPosition(position).toString().equals("清爽配餐")){
                       value += 40;
                       set_coll= 1;
                   }//else if equals 清爽配餐
                   else if(parent.getItemAtPosition(position).toString().equals("酷炫配餐")){
                       value += 50;
                       set_coll = 2;
                   }//else if equals 酷炫配餐
                   else if(parent.getItemAtPosition(position).toString().equals("勁脆配餐")){
                       value += 60;
                       set_coll = 3;
                   }//else if equals 勁脆配餐
                    Intent ii = new Intent();
                    Bundle bb = new Bundle();
                    ii.setClass(set_coll.this, finish.class);
                    bb.putInt("price",value);
                    bb.putInt("set",set);
                    bb.putInt("set_coll",set_coll);
                    bb.putInt("which",1);
                    ii.putExtras(bb);
                    startActivity(ii);
                }
            };//ListView.OnItemClickListener gotosetcoll

    public class MyAdapter extends BaseAdapter{
        private LayoutInflater myInflater;
        public MyAdapter(Context c){
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount(){
            return colls.length;
        }
        @Override
        public Object getItem(int position){
            return colls[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            convertView = myInflater.inflate(R.layout.listview_collcation, null);


            // 取得 mylayout.xml 中的元件
            ImageView imgcoll = (ImageView) convertView.findViewById(R.id.imgcoll);
            TextView collName = ((TextView) convertView.findViewById(R.id.collName));
            TextView priceName = ((TextView) convertView.findViewById(R.id.price));
            // 設定元件內容
            imgcoll.setImageResource(collIds[position]);
            collName.setText(colls[position]);
            priceName.setText(price[position]);
            return convertView;
        }
    }//Myadapter
}//set
