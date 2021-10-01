package com.example.hehe.Signup;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    // 서버 URL 설정 ( JSP 파일 연동 )
    final static private String URL = "http://18.117.8.18:8080/planco/login.jsp";
    private Map<String, String> map;

    public LoginRequest(String email, String passwd, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("email", email);
        map.put("passwd", passwd);
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}