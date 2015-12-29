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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.util.Log;
public class set extends ActionBarActivity {
    ListView lv;
    int value;
    int set;
    int[] resIds = new int[]{ R.drawable.bigmac,
                             R.drawable.hotcheckenleg,
                             R.drawable.checkenleg,
                             R.drawable.macchecken6,
                             R.drawable.macchecken9,
                             R.drawable.friedchecken2,
                             R.drawable.checken,
                             R.drawable.fish};
    String[] foods= new String[] {"大麥克","勁辣雞腿堡","板烤雞腿堡","麥克雞塊(6塊)","麥克雞塊(9塊)","麥脆雞(2塊)","麥香雞","麥香魚"};
    String[] price = { "99元","99元","99元","79元","89元","109元","89元","89元"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        lv = (ListView)findViewById(R.id.lv);
        //lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        MyAdapter adapter=new MyAdapter(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(gotosetcoll);
    }//onCreate

    private ListView.OnItemClickListener gotosetcoll=
            new ListView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // 顯示 ListView 的選項內容
                    Intent i = new Intent();
                    Bundle b = new Bundle();
                    if(parent.getItemAtPosition(position).toString().equals("大麥克")){
                        value = 99;
                        set = 0;
                    }//if equals 大麥克
                    else if(parent.getItemAtPosition(position).toString().equals("勁辣雞腿堡")){
                        value = 99;
                        set = 1;
                    }//else equals 勁辣雞腿堡
                    else if(parent.getItemAtPosition(position).toString().equals("板烤雞腿堡")){
                        value = 99;
                        set = 2;
                    }//else equals 板烤雞腿堡
                    else if(parent.getItemAtPosition(position).toString().equals("麥克雞塊(6塊)")){
                        value = 79;
                        set = 3;
                    }//else equals 麥克雞塊(6塊)
                    else if(parent.getItemAtPosition(position).toString().equals("麥克雞塊(9塊)")){
                        value = 89;
                        set = 4;
                    }//else equals 麥克雞塊(9塊)
                    else if(parent.getItemAtPosition(position).toString().equals("麥脆雞(2塊)")){
                        value = 109;
                        set = 5;
                    }//else equals 麥脆雞(2塊)
                    else if(parent.getItemAtPosition(position).toString().equals("麥香雞")){
                        value = 89;
                        set = 6;
                    }//else equals 麥香雞
                    else if(parent.getItemAtPosition(position).toString().equals("麥香魚")){
                        value = 89;
                        set = 7;
                    }//else equals 麥香魚
                    i.setClass(set.this, set_coll.class);
                    b.putInt("price",value);
                    b.putInt("set",set);
                    i.putExtras(b);
                    startActivity(i);
                }
            };//ListView.OnItemClickListener gotosetcoll
    public class MyAdapter extends BaseAdapter{
        private LayoutInflater myInflater;
        public MyAdapter(Context c){
            myInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount(){
            return foods.length;
        }
        @Override
        public Object getItem(int position){
            return foods[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            convertView = myInflater.inflate(R.layout.lisview_tset, null);

            // 取得 mylayout.xml 中的元件
            ImageView imgLogo = (ImageView) convertView.findViewById(R.id.imgLogo);
            TextView txtName = ((TextView) convertView.findViewById(R.id.txtName));
            TextView priceName = ((TextView) convertView.findViewById(R.id.price));

            // 設定元件內容
            imgLogo.setImageResource(resIds[position]);
            txtName.setText(foods[position]);
            priceName.setText(price[position]);
            return convertView;
        }
    }//Myadapter
}//set
