package com.example.hehe;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CatalogActivity extends AppCompatActivity implements View.OnClickListener{

    ColorStateList def;
    TextView item1, item2, select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);

        select = findViewById(R.id.select1);
        def = item2.getTextColors();

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.item1) {
            select.animate().x(0).setDuration(100);
            item1.setTextColor(Color.WHITE);
            item2.setTextColor(def);
        } else if(v.getId() == R.id.item2) {
            select.animate().x(0).setDuration(100);
            item1.setTextColor(def);
            item2.setTextColor(Color.WHITE);
            int size = item2.getWidth();
            select.animate().x(size).setDuration(100);
        }
    }
}
