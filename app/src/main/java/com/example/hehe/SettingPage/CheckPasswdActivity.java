package com.example.hehe.SettingPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hehe.FindPasswdActivity;
import com.example.hehe.R;

public class CheckPasswdActivity extends AppCompatActivity {

    Button btn_check;
    Button find_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_passwd);

        btn_check = findViewById(R.id.button3);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ChangePasswdActivity.class);
                startActivity(intent);
            }
        });

        find_btn = findViewById(R.id.button2);
        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindPasswdActivity.class);
                startActivity(intent);
            }
        });



    }
}