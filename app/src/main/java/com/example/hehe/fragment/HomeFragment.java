package com.example.hehe.fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hehe.HOME.HomeViewPagerAdapter;
import com.example.hehe.R;
import com.example.hehe.VS.VSViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        tabLayout = mView.findViewById(R.id.tab_layout_home);
        viewPager = mView.findViewById(R.id.viewpager_home);

        int i = 1/2;
        //tabLayout.setBackgroundColor(Color.rgb(160,0,226));

        tabLayout.setBackgroundResource(R.drawable.round_mini);
        tabLayout.setTabTextColors(Color.rgb(186,186,186), Color.rgb(0,0,0)); // 탭 선택시 텍스트 컬러 변경
        tabLayout.setSelectedTabIndicator(R.drawable.round_mini2);
        //tabLayout.setSelectedTabIndicatorHeight(150);
        //tabLayout.setSelectedTabIndicatorColor(Color.rgb(193, 240, 133));


        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        return mView;

    }
}