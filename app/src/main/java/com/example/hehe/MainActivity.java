package com.example.hehe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.hehe.fragment.MainFragment;
import com.example.hehe.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

private ViewPager viewPager;
private BottomNavigationView bottomNavigationView;

MainFragment mainFragment;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        // 메인화면
        Intent intent = getIntent();
        String txt1 = intent.getExtras().getString("nickname");
        Intent intent1 = new Intent(MainActivity.this, MainFragment.class);
        intent1.putExtra("nickname",txt1);
        System.out.println("111111111111111111111111"+txt1);
        Bundle bundle = new Bundle();
        bundle.putString("nickname","text");
        mainFragment.setArguments(bundle);
        mainFragment.arguments = bundle;


        //TextView textView1 = (TextView)findViewById(R.id.textView12);
        //textView1.setText(txt1);

        Intent myIntent = new Intent(this,MainActivity.class);
        myIntent.putExtra("번호",12345);
        myIntent.putExtra("메시지","이것이 메시지의 value 입니다.");


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        System.out.println("1111111111111111111111112"+txt1);
        viewPager.setAdapter(adapter);
        System.out.println("1111111111111111111111113"+txt1);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_main).setChecked(true);
                       break;

                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_vs).setChecked(true);
                        break;

                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_set).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        System.out.println("1111111111111111111111114"+txt1);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_main:
                        viewPager.setCurrentItem(0);
                        break;


                    case R.id.menu_vs:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.menu_set:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
        System.out.println("1111111111111111111111115"+txt1);

    }
}