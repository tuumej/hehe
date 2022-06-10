package com.example.hehe.VS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hehe.R;
import com.example.hehe.Sum.SumActivity;

public class PopActivitySpend extends AppCompatActivity {

    Button btn_94;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_spend);

        btn_94 = findViewById(R.id.button94);
        btn_94.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SumActivity.class);
                startActivity(intent);
            }
        });
    }
}