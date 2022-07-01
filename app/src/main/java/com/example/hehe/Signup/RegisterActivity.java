package com.example.hehe.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.hehe.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_Nickname, et_Email, et_Passwd, et_Passwd2;
    private TextView et_Nickname_warn, et_Email_warn, et_Passwd_warn, et_Passwd2_warn;
    private Button btn_register;
    private CheckBox privacy_check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // EditText 입력 값
        et_Nickname = findViewById(R.id.et_Nickname);
        et_Email = findViewById(R.id.et_Email);
        et_Passwd = findViewById(R.id.et_Passwd);
        et_Passwd2 = findViewById(R.id.et_Passwd2);

        // TextView
        et_Nickname_warn = findViewById(R.id.et_Nickname_warn);
        et_Email_warn = findViewById(R.id.et_Email_warn);
        et_Passwd_warn = findViewById(R.id.et_Passwd_warn);
        et_Passwd2_warn = findViewById(R.id.et_Passwd2_warn);
            
        // 닉네임 최대 8글자 제한 확인
        et_Nickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int len = et_Nickname.getText().toString().length();
                // 닉네임 최대 8 자리
                if (len > 8) {
                    et_Nickname_warn.setVisibility(View.VISIBLE);
                    return;

                } else {
                    et_Nickname_warn.setVisibility(View.INVISIBLE);
                    return;

                }
            }
        });

        // 이메일 형식 확인
        et_Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(et_Email.getText()).matches()) {
                    et_Email_warn.setVisibility(View.VISIBLE);
                    return;

                } else {
                    et_Email_warn.setVisibility(View.INVISIBLE);
                    return;

                }
            }
        });

        // 비밀번호 조건 확인 & 비밀번호 - 비밀번호 재입력 일치 여부 확인
        et_Passwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(et_Passwd2.getText().toString().length() > 0) {
                    if (!et_Passwd.getText().toString().equals(et_Passwd2.getText().toString())) {
                        et_Passwd2_warn.setVisibility(View.VISIBLE);
                        return;

                    } else {
                        et_Passwd2_warn.setVisibility(View.INVISIBLE);
                        return;

                    }
                }
                if (!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", et_Passwd.getText())) {
                    et_Passwd_warn.setVisibility(View.VISIBLE);
                    return;

                } else {
                    et_Passwd_warn.setVisibility(View.INVISIBLE);
                    return;

                }
            }
        });

        // 비밀번호 - 비밀번호 재입력 일치 여부 확인 
        et_Passwd2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!et_Passwd.getText().toString().equals(et_Passwd2.getText().toString())) {
                    et_Passwd2_warn.setVisibility(View.VISIBLE);
                    return;

                } else {
                    et_Passwd2_warn.setVisibility(View.INVISIBLE);
                    return;

                }
            }
        });

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {

                String email = et_Email.getText().toString().trim();
                String passwd = et_Passwd.getText().toString().trim();
                String passwd2 = et_Passwd2.getText().toString().trim();
                String nickname = et_Nickname.getText().toString().trim();

                privacy_check1 = (CheckBox) findViewById(R.id.privacy_check1);

               // 회원가입 정보 조건 부합하지 않을 경우, 포커스 이동 및 알림 발생
                if(et_Nickname_warn.getVisibility() == View.VISIBLE) {
                    et_Nickname.requestFocus();
                    Toast.makeText(getApplicationContext(), "입력정보를 다시 확인해주세요.", Toast.LENGTH_LONG).show();
                    return;
                } else if(et_Email_warn.getVisibility() == View.VISIBLE) {
                    et_Email.requestFocus();
                    Toast.makeText(getApplicationContext(), "입력정보를 다시 확인해주세요.", Toast.LENGTH_LONG).show();
                    return;
                } else if(et_Passwd_warn.getVisibility() == View.VISIBLE) {
                    et_Passwd.requestFocus();
                    Toast.makeText(getApplicationContext(), "입력정보를 다시 확인해주세요.", Toast.LENGTH_LONG).show();
                    return;
                } else if(et_Passwd2_warn.getVisibility() == View.VISIBLE) {
                    et_Passwd2.requestFocus();
                    Toast.makeText(getApplicationContext(), "입력정보를 다시 확인해주세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                
                // 회원 정보 널 값 체크
                if (TextUtils.isEmpty(nickname)) {

                    Toast.makeText(getApplicationContext(), "닉네입 입력해주세요.", Toast.LENGTH_LONG).show();
                    et_Nickname.requestFocus();
                    return;

                } else if (TextUtils.isEmpty(email)) {

                    Toast.makeText(getApplicationContext(), "이메일 입력해주세요.", Toast.LENGTH_LONG).show();
                    et_Email.requestFocus();
                    return;

                } else if (TextUtils.isEmpty(passwd)) {

                    Toast.makeText(getApplicationContext(), "비밀번호 입력해주세요.", Toast.LENGTH_LONG).show();
                    et_Passwd.requestFocus();
                    return;

                } else if (TextUtils.isEmpty(passwd2)) {

                    Toast.makeText(getApplicationContext(), "비밀번호 재입력 입력해주세요.", Toast.LENGTH_LONG).show();
                    et_Passwd2.requestFocus();
                    return;

                }

                // 개인정보 수집 동의 여부 체크(필수)
                if(privacy_check1.isChecked() == false) {

                    Toast.makeText(getApplicationContext(), "개인정보 수집 및 동의는 필수입니다.", Toast.LENGTH_LONG).show();
                    return;

                }

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
