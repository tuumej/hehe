package com.example.hehe.VS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class VSViewPagerAdapter extends FragmentStatePagerAdapter {


    public VSViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case  0:
                return new Tab1FragmentVS();

            case  1:
                return new Tab2FragmentVS();

            case  2:
                return new Tab3FragmentVS();

            case  3:
                return new Tab4FragmentVS();

            default:
                return new Tab1FragmentVS();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case  0:
                return "밥";

            case  1:
                return "커피";

            case  2:
                return "취미";

            case  3:
                return "쇼핑";

            default:
                return "밥";
        }
    }
}
