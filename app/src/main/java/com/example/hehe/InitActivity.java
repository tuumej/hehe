package com.example.hehe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hehe.fragment.SetFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InitActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    Button click_main_btn;
    Button click_main_btn2;
    Button click_main_btn3;
    Button click_main_btn4;


    private FloatingActionButton fab_main, fab_sub1, fab_sub2;
    private Animation fab_open, fab_close;
    private boolean isFabOpen = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_init);
        mContext = getApplicationContext();


        click_main_btn = findViewById(R.id.button22);
        click_main_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        click_main_btn2 = findViewById(R.id.button21);
        click_main_btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        click_main_btn3 = findViewById(R.id.button24);
        click_main_btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        click_main_btn4 = findViewById(R.id.button23);
        click_main_btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        fab_open = AnimationUtils.loadAnimation(mContext,R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(mContext,R.anim.fab_close);

        fab_main = (FloatingActionButton)findViewById(R.id.fab_main);
        fab_sub1 = (FloatingActionButton)findViewById(R.id.fab_sub1);
        fab_sub2 = (FloatingActionButton)findViewById(R.id.fab_sub2);

        fab_main.setOnClickListener((View.OnClickListener) this);
        fab_sub1.setOnClickListener((View.OnClickListener) this);
        fab_sub2.setOnClickListener((View.OnClickListener) this);

    }

   @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.fab_main:
                toggleFab();
                break;

            case R.id.fab_sub1:
                toggleFab();
                Toast.makeText(this,"프로젝트 추가",Toast.LENGTH_SHORT).show();
                break;

            case R.id.fab_sub2:
                toggleFab();
                Toast.makeText(this,"프로젝트 삭제",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void toggleFab(){
        if (isFabOpen) {
            fab_main.setImageResource(R.drawable.plus);
            fab_sub1.startAnimation(fab_close);
            fab_sub2.startAnimation(fab_close);
            fab_sub1.setClickable(false);
            fab_sub2.setClickable(false);
            isFabOpen = false;
        } else {
            fab_main.setImageResource(R.drawable.plus);
            fab_sub1.startAnimation(fab_open);
            fab_sub2.startAnimation(fab_open);
            fab_sub1.setClickable(true);
            fab_sub2.setClickable(true);
            isFabOpen = true;

        }

    }
}
