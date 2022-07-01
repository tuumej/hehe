package com.example.hehe.SettingPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hehe.R;
import com.example.hehe.Signup.LoginActivity;
import com.example.hehe.Signup.RegisterActivity;

public class ChangePasswdActivity extends AppCompatActivity {

    Button change_pw_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passwd);


        change_pw_btn = findViewById(R.id.change_pw_btn);
        change_pw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}