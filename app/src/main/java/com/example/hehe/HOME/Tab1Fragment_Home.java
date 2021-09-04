package com.example.hehe.HOME;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hehe.R;
import com.github.mikephil.charting.charts.PieChart;


public class Tab1Fragment_Home extends Fragment {



    public Tab1Fragment_Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab1__home, container, false);
    }
}