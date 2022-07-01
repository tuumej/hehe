package com.example.hehe.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.hehe.FindPasswdActivity;
import com.example.hehe.MainActivity;
import com.example.hehe.R;
import com.example.hehe.SettingPage.SetIdActivity;
import com.example.hehe.fragment.MainFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText et_Email, et_Passwd;
    private Button btn_login;
    private Button btn_signup;
    private Button btn_find_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        et_Email = findViewById(R.id.et_Email);
        et_Passwd = findViewById(R.id.et_Passwd);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {

                String email = et_Email.getText().toString();
                String passwd = et_Passwd.getText().toString();


                // 로그인 버튼 클릭 시 수행
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            Boolean success = jsonObject.getBoolean("success");
                            String E_MAIL = jsonObject.getString("E_MAIL");
                            String NICK_NAME = jsonObject.getString("NICK_NAME");
                            String FIRST_ACCOUNT_BOOK_TITLE = jsonObject.getString("FIRST_ACCOUNT_BOOK_TITLE");
                            String FIRST_ACCOUNT_BOOK_PAY = jsonObject.getString("FIRST_ACCOUNT_BOOK_PAY");
                            String SECOND_ACCOUNT_BOOK_TITLE = jsonObject.getString("SECOND_ACCOUNT_BOOK_TITLE");
                            String SECOND_ACCOUNT_BOOK_PAY = jsonObject.getString("SECOND_ACCOUNT_BOOK_PAY");
                            String THIRD_ACCOUNT_BOOK_TITLE = jsonObject.getString("THIRD_ACCOUNT_BOOK_TITLE");
                            String THIRD_ACCOUNT_BOOK_PAY = jsonObject.getString("THIRD_ACCOUNT_BOOK_PAY");
                            String FORTH_ACCOUNT_BOOK_TITLE = jsonObject.getString("FORTH_ACCOUNT_BOOK_TITLE");
                            String FORTH_ACCOUNT_BOOK_PAY = jsonObject.getString("FORTH_ACCOUNT_BOOK_PAY");
                            String USER_KEY = jsonObject.getString("USER_KEY");

                            if(success) { // 로그인 성공 시

                                Toast.makeText(getApplicationContext(), "환영합니다.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("E_MAIL",E_MAIL);
                                intent.putExtra("NICK_NAME",NICK_NAME);
                                intent.putExtra("FIRST_ACCOUNT_BOOK_TITLE",FIRST_ACCOUNT_BOOK_TITLE);
                                intent.putExtra("FIRST_ACCOUNT_BOOK_PAY",FIRST_ACCOUNT_BOOK_PAY);
                                intent.putExtra("SECOND_ACCOUNT_BOOK_TITLE",SECOND_ACCOUNT_BOOK_TITLE);
                                intent.putExtra("SECOND_ACCOUNT_BOOK_PAY",SECOND_ACCOUNT_BOOK_PAY);
                                intent.putExtra("THIRD_ACCOUNT_BOOK_TITLE",THIRD_ACCOUNT_BOOK_TITLE);
                                intent.putExtra("THIRD_ACCOUNT_BOOK_PAY",THIRD_ACCOUNT_BOOK_PAY);
                                intent.putExtra("FORTH_ACCOUNT_BOOK_TITLE",FORTH_ACCOUNT_BOOK_TITLE);
                                intent.putExtra("FORTH_ACCOUNT_BOOK_PAY",FORTH_ACCOUNT_BOOK_PAY);
                                intent.putExtra("USER_KEY",USER_KEY);

                                startActivity(intent);

                            } else {    // 로그인 실패 시시

                                Toast.makeText(getApplicationContext(), "회원정보가 틀렸습니다.",Toast.LENGTH_LONG).show();
                                return;

                            }
                                //System.out.println("##############"+jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                // Volley를 이용해 서버로 회원가입 요청
                LoginRequest loginRequest = new LoginRequest(email, passwd, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }
        });

        btn_signup = findViewById(R.id.btn_registeractivity);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_find_pw = findViewById(R.id.button13);
        btn_find_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindPasswdActivity.class);
                startActivity(intent);
            }
        });

    }
}
