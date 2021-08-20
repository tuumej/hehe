package com.example.hehe.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hehe.FindPasswdActivity;
import com.example.hehe.InitActivity;
import com.example.hehe.R;

public class SignInActivity extends AppCompatActivity {

    Button sign_btn;
    Button fi_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sign_btn = findViewById(R.id.button12);
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

        fi_btn = findViewById(R.id.button13);
        fi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindPasswdActivity.class);
                startActivity(intent);
            }
        });


    }
}