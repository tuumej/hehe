package com.example.hehe.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.hehe.R;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_Nickname, et_Email, et_Passwd, et_Passwd2;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // EditText 입력 값
        et_Nickname = findViewById(R.id.et_Nickname);
        et_Email = findViewById(R.id.et_Email);
        et_Passwd = findViewById(R.id.et_Passwd);
        et_Passwd2 = findViewById(R.id.et_Passwd2);


        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {

                // et_Email.getText(), et_Passwd.getText(), et_Nickname.getText()
                String email = et_Email.getText().toString().trim();
                String passwd = et_Passwd.getText().toString().trim();
                String passwd2 = et_Passwd2.getText().toString().trim();
                String nickname = et_Nickname.getText().toString().trim();

                // 회원 정보 널 값 체크
                if (TextUtils.isEmpty(nickname)) {

                    Toast.makeText(getApplicationContext(), "닉네입 입력해주세요.", Toast.LENGTH_LONG).show();
                    return;

                } else if (TextUtils.isEmpty(email)) {

                    Toast.makeText(getApplicationContext(), "이메일 입력해주세요.", Toast.LENGTH_LONG).show();
                    return;

                } else if (TextUtils.isEmpty(passwd) || TextUtils.isEmpty(passwd2)) {

                    Toast.makeText(getApplicationContext(), "비밀번호 입력해주세요.", Toast.LENGTH_LONG).show();
                    return;

                }

                // 비밀번호 일치 체크
                /*if(passwd != passwd2) {

                    Toast.makeText(getApplicationContext(), "비비비111111", Toast.LENGTH_LONG).show();
                    return;

                }*/

                // 회원가입 버튼 클릭 시 수행
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success) {   // 회원등록에 성공한 경우

                                Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);

                            } else {    // 회원등록에 실패한 경우

                                Toast.makeText(getApplicationContext(), "회원등록에 실패하였습니다.",Toast.LENGTH_LONG).show();
                                return;

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                // Volley를 이용해 서버로 회원가입 요청
                RegisterRequest registerRequest = new RegisterRequest(email, passwd, nickname, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });

    }
}
