    package com.example.hehe.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.hehe.R;
import com.example.hehe.SettingPage.AddBFActivity;
import com.example.hehe.SettingPage.BellActivity;
import com.example.hehe.SettingPage.LogoutActivity;
import com.example.hehe.SettingPage.SetIdActivity;


public class SetFragment extends Fragment {
    private Button id_set_btn;

    Button btn_id_set;

    public SetFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_set, container, false);


       btn_id_set= v.findViewById(R.id.id_set_btn); //화면 전환하고 싶은 버튼 id 입력 <- 계정 설정
       btn_id_set.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(getActivity(), SetIdActivity.class);
               intent.putExtra("USER_KEY","1111");
               System.out.println("11111");
               startActivity(intent);
           }


       });

        btn_id_set= v.findViewById(R.id.add_bf_btn); //화면 전환하고 싶은 버튼 id 입력 <- 친구 설정
        btn_id_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddBFActivity.class); //버튼 클릭시 전환할 화면 입력
                startActivity(intent);
            }
        });

        btn_id_set= v.findViewById(R.id.bell_btn); //화면 전환하고 싶은 버튼 id 입력 <- 알림 설정
        btn_id_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BellActivity.class);
                startActivity(intent);
            }
        });

        btn_id_set= v.findViewById(R.id.id_out_btn); //화면 전환하고 싶은 버튼 id 입력 <- 로그아웃
        btn_id_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LogoutActivity.class);
                startActivity(intent);
            }
        });

       return v;
   
    }





}
