package com.example.hehe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hehe.Sum.SumActivity;
import com.example.hehe.VS.PopActivitySpend;

public class PopActivityIncome extends AppCompatActivity {

    Button set_btn123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_income);

        set_btn123 = findViewById(R.id.button9);
        set_btn123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PopActivitySpend.class);
                startActivity(intent);

            }
        });



    }
}
