package com.example.hehe.Sum;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.hehe.R;


public class SumFragment2 extends Fragment {

    public SumFragment2(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sum2,container,false);
        String[] menuItems = {"내역이름1","내역이름2","내역이름3","내역이름4","내역이름5","내역이름6","내역이름7","내역이름8","내역이름9","내역이름10"};

        ListView listView = view.findViewById(R.id.listView2);

        ArrayAdapter<String>listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);
        return view;


    }
}