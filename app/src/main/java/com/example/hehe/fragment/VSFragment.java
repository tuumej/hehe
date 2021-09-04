package com.example.hehe.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hehe.R;
import com.example.hehe.VS.VSViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class VSFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mView;




    public VSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       mView = inflater.inflate(R.layout.fragment_vs, container, false);

        tabLayout = mView.findViewById(R.id.tab_layout_vs);
        viewPager = mView.findViewById(R.id.vs_viewpager);

        VSViewPagerAdapter adapter = new VSViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        tabLayout.setTabTextColors(Color.rgb(0,0,0), Color.rgb(0,0,0)); // 탭 선택시 텍스트 컬러 변경
        tabLayout.setSelectedTabIndicatorColor(Color.rgb(193,240,133)); // 탭 선택시 밑줄 색 변경

        tabLayout.setupWithViewPager(viewPager);


        return mView;
    }
}