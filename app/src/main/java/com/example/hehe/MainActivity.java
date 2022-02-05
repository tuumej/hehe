package com.example.hehe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.hehe.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

private ViewPager viewPager;
private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("num","############################ 1");

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        Log.v("num","############################ 2");

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        Log.v("num","############################ 3");

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            TextView txt1,txt2;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.v("num","############################ 11");
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_main).setChecked(true);
                        Log.v("num","############################ 4");
                        txt1 = (TextView)findViewById(R.id.main_nickname);
                        txt1.setText("txt1");
                       break;

                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_vs).setChecked(true);
                        Log.v("num","############################ 5");
                        break;

                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_set).setChecked(true);
                        txt2 = (TextView)findViewById(R.id.set_nickname);
                        txt2.setText("txt1");
                        Log.v("num","############################ 6");
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.v("num","############################ 12");
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                TextView txt1,txt2;

                switch (item.getItemId()){
                    case R.id.menu_main:
                        viewPager.setCurrentItem(0);
                        txt1 = (TextView)findViewById(R.id.main_nickname);
                        txt1.setText("txt1");
                        Log.v("num","############################ 7");
                        break;

                    case R.id.menu_vs:
                        viewPager.setCurrentItem(1);
                        Log.v("num","############################ 8");
                        break;

                    case R.id.menu_set:
                        viewPager.setCurrentItem(2);
                        txt2 = (TextView)findViewById(R.id.set_nickname);
                        txt2.setText("txt1");
                        Log.v("num","############################ 9");
                        break;
                }
                return true;
            }
        });

        Log.v("num","############################ 10");

    }
}