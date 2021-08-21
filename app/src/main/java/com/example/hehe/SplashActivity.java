package com.example.hehe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.hehe.Signup.SignInActivity;

public class SplashActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Intent intent= new Intent(this, SignInActivity.class);
        startActivity(intent);

        finish();
    }
}


