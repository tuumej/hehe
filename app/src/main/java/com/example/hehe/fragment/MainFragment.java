package com.example.hehe.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hehe.MainActivity;
import com.example.hehe.PopActivityIncome;
import com.example.hehe.R;
import com.example.hehe.Ring.RingActivity;
import com.example.hehe.Sum.SumActivity;


public class MainFragment extends Fragment {
    public Bundle arguments;
    Button btn_sum;
    ImageButton img_btn;
    TextView main_nickname;

    public MainFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        btn_sum = v.findViewById(R.id.button16);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopActivityIncome.class);
                startActivity(intent);

            }
        });

        Bundle bundle = getArguments();
        String text = bundle.getString("nickname");
        main_nickname.setText(text);

        main_nickname = v.findViewById(R.id.textView12);
        main_nickname.setText("1111");

        btn_sum = v.findViewById(R.id.button17);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SumActivity.class);
                startActivity(intent);

            }
        });

        btn_sum = v.findViewById(R.id.button19);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SumActivity.class);
                startActivity(intent);

            }
        });

        btn_sum = v.findViewById(R.id.button14);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SumActivity.class);
                startActivity(intent);

            }
        });

        img_btn = v.findViewById(R.id.imageButton4);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RingActivity.class);
                startActivity(intent);

            }
        });

        return v;

    }
}