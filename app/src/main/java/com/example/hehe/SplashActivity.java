package com.example.hehe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.hehe.Signup.LoginActivity;
import com.example.hehe.onboarding.OnboardingActivity;

public class SplashActivity extends AppCompatActivity {

private  static final String Tag = "SplashActivity";

@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_splash);
startLoading();
}
private void startLoading(){
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Log.e(Tag,"Application Running.....");
            startActivity(new Intent(getApplicationContext(), OnboardingActivity.class));
            finish();
        }
    }, 5000);
}

}