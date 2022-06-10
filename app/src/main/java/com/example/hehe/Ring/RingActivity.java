package com.example.hehe.Ring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.hehe.R;

import java.util.ArrayList;

public class RingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);

        ListView listView = findViewById(R.id.listView);
        RingAdapter adapter = new RingAdapter();
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.meal_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.home_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.insure_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.pray_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.back_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.life_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.coffee_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.etc_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.hobby_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.shop_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.meal_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.shop_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.meal_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.etc_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.shop_pay));
        adapter.addItem(new RingItem("000님이 친구 요청을 하였습니다.",R.drawable.meal_pay));

        listView.setAdapter(adapter);

    }
        class RingAdapter extends BaseAdapter {
        ArrayList<RingItem> items = new ArrayList<RingItem>();

        @Override
        public int getCount(){
            return items.size();
        }

        public void addItem(RingItem item){
            items.add(item);
        }
        @Override
        public Object getItem(int position){
            return position;
        }

        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            RingItemView ringItemView = null;

            if(convertView == null){
                ringItemView = new RingItemView(getApplicationContext());
            }
            else {
                ringItemView =(RingItemView) convertView;
            }

            RingItem item = items.get(position);
            ringItemView.setName(item.getName());
            ringItemView.setImageView(item.getResId());
            return ringItemView;
        }
    }
}