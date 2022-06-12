package com.example.hehe.Signup;

import android.provider.ContactsContract;
import android.util.Patterns;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정 ( JSP 파일 연동 )
    final static private String URL = "http://192.168.0.4:8080/planco/registerAction.do";
    private Map<String, String> map;

    public RegisterRequest(String email, String passwd, String nickname, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("E_MAIL", email);
        map.put("PASSWD", passwd);
        map.put("NICK_NAME", nickname);

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(RegisterRequest.this,"이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        }


    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
