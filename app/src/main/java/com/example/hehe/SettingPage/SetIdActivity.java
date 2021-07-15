package com.example.hehe.SettingPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hehe.R;

public class SetIdActivity extends AppCompatActivity {

    Button change_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_id);

        change_btn = findViewById(R.id.change_id_btn);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CheckPasswdActivity.class);
                startActivity(intent);
            }
        });
    }
}