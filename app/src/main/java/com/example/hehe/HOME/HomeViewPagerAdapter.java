package com.example.hehe.HOME;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.hehe.fragment.HomeFragment;
import com.example.hehe.fragment.SetFragment;
import com.example.hehe.fragment.VSFragment;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {


    public HomeViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case  0:
                return new Tab1Fragment_Home();

            case  1:
                return new Tab2Fragment_Home();

            default:
                return new Tab1Fragment_Home();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case  0:
                return "통계";

            case  1:
                return "상세 내역";

            default:
                return "밥";
        }
    }
}
