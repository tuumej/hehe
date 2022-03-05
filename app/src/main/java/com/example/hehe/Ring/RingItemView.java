package com.example.hehe.Ring;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.hehe.R;

public class RingItemView extends LinearLayout {

    TextView textView;
    ImageView imageView;

    public RingItemView(Context context){
        super(context);
        init(context);
    }

    public RingItemView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }

    private void  init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_ring_list,this,true);

        textView = findViewById(R.id.textView123);
        imageView = findViewById(R.id.imageView123);

    }

    public void setName(String name){
        textView.setText(name);
    }

    public void setImageView(int resId){
        imageView.setImageResource(resId);
    }

}
