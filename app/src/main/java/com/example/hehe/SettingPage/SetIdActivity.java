package com.example.hehe.SettingPage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hehe.MainActivity;
import com.example.hehe.R;

public class SetIdActivity extends AppCompatActivity implements View.OnClickListener{

    Button change_btn;
    Button fire_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_id);

        findViewById(R.id.button).setOnClickListener(this);
        change_btn = findViewById(R.id.change_id_btn);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CheckPasswdActivity.class);
                startActivity(intent);
            }
        });

        fire_btn = findViewById(R.id.fire_botton);
        fire_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LogFireActivity.class);
                startActivity(intent);
            }
        });


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                new AlertDialog.Builder(this)
                        .setMessage("진짜 탈퇴하시겠습니까 ?")
                        .setPositiveButton("아니요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("Dialog","탈퇴안함");
                                Toast.makeText(getApplicationContext(),"탈퇴취소",Toast.LENGTH_LONG).show();


                            }
                        })
                        .setNeutralButton("탈퇴", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);  //탈퇴시 현재는 MainActivity로 돌아가게 설정했으나 구현완료시 login화면으로 변경 필요
                                startActivity(intent1);

                            }
                        })
                        .setCancelable(false) //뒤로가기 버튼으로 팝업창 안닫힘
                        .show();
                break;
        }
    }


}