package com.example.hehe.SettingPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hehe.Adapter;
import com.example.hehe.R;

import java.util.ArrayList;

public class AddBFActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bf);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView. VERTICAL, false)) ;

        adapter = new Adapter();
        for(int i =0; i<100; i++) {
            String str = i + "친구";
            adapter.setArrayData(str);
        }

        recyclerView.setAdapter(adapter);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView. VERTICAL, false)) ;

        adapter = new Adapter();
        for(int i =0; i<10; i++) {
            String str = i + "친구";
            adapter.setArrayData(str);
        }

        recyclerView.setAdapter(adapter);




    }
}