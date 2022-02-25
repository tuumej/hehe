package com.example.hehe.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.hehe.PopActivity;
import com.example.hehe.R;
import com.example.hehe.Ring_Activity;
import com.example.hehe.Sum.SumActivity;


public class MainFragment extends Fragment {
    Button btn_sum;
    ImageButton img_btn;

    public MainFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        btn_sum = v.findViewById(R.id.button19);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopActivity.class);
                startActivity(intent);

            }
        });



        btn_sum = v.findViewById(R.id.button28);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SumActivity.class);
                startActivity(intent);

            }
        });

        btn_sum = v.findViewById(R.id.button29);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SumActivity.class);
                startActivity(intent);

            }
        });

        btn_sum = v.findViewById(R.id.button30);
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
                Intent intent = new Intent(getActivity(), Ring_Activity.class);
                startActivity(intent);

            }
        });

        return v;

    }
}