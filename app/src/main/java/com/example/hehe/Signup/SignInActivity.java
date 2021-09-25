package com.example.hehe.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hehe.FindPasswdActivity;
import com.example.hehe.MainActivity;
import com.example.hehe.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SignInActivity extends AppCompatActivity {

    Button sign_btn;
    Button fi_btn;
    Button set_main_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        sign_btn = findViewById(R.id.button20);
        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
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

        /* 로그인 버튼
         * 아이디 : e_mail - editTextTextEmailAddress3
         * 패스워드 : passwd - editTextTextPassword6
         *
         */

        set_main_btn = findViewById(R.id.button11);
        EditText e_mail, passwd;
        e_mail = (EditText)findViewById(R.id.editTextTextEmailAddress3);
        passwd = (EditText)findViewById(R.id.editTextTextPassword6);

        set_main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                try {

                    // 앱 화면 id/pw 데이터 가져오기
                    String id, pw, result, str;
                    id = e_mail.getText().toString();
                    pw = passwd.getText().toString();

                    // mysql 데이터 연동
                    String sendMsg, receiveMsg;

                    URL url = new URL("http://18.117.8.18:8080/planco/mysqlJdbc.jsp");
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                    conn.setRequestMethod("POST");
                    OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                    // 전송 데이터 get 방식으로 작성
                    sendMsg = "id=" + id + "&pw=" + pw;

                    osw.write(sendMsg);
                    osw.flush();

                    // jsp와 통신 성공 시 수행
                    if(conn.getResponseCode() == conn.HTTP_OK) {
                        InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                        BufferedReader br = new BufferedReader(tmp);
                        StringBuffer sb = new StringBuffer();

                        // jsp 에서 보낸 값을 받는 부분
                        while((str = br.readLine()) != null) {
                            sb.append(str);
                        }

                        receiveMsg = br.toString();

                        // 성공 시, 메인화면으로 전환
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    } else {
                        // 통신 실패
                    }

                } catch (Exception e) {
                    Log.i("DBtest", ".... ERROR.....!");
                    Log.i("DBtest", String.valueOf(e));
                }

                    }
                }.start();
            }
        });


    }
}