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

import com.example.hehe.Signup.UserCacheInfo;
import com.example.hehe.fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private TextView textView, textView1,textView2,textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        System.out.println("%%%%%%%%%%%%%%%%%%% :" +intent.getStringExtra("E_MAIL"));
        UserCacheInfo.E_MAIL = intent.getStringExtra("E_MAIL");
        UserCacheInfo.NICK_NAME = intent.getStringExtra("NICK_NAME");
        UserCacheInfo.USER_KEY = intent.getStringExtra("USER_KEY");
        UserCacheInfo.FIRST_ACCOUNT_BOOK_TITLE = intent.getStringExtra("FIRST_ACCOUNT_BOOK_TITLE");
        UserCacheInfo.FIRST_ACCOUNT_BOOK_CASH = intent.getStringExtra("FIRST_ACCOUNT_BOOK_CASH");
        //UserCacheInfo.NICK_NAME = "AMDIN";
       //UserCacheInfo.E_MAIL = "AMDIN";

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        textView = (TextView)findViewById(R.id.fragmane_NICKNAME);
                        textView.setText(UserCacheInfo.NICK_NAME);
                        textView2 = (TextView)findViewById(R.id.first_account_book_cash);
                        textView2.setText(UserCacheInfo.FIRST_ACCOUNT_BOOK_CASH);
                        textView3 = (TextView)findViewById(R.id.first_account_book_title);
                        textView3.setText(UserCacheInfo.FIRST_ACCOUNT_BOOK_TITLE);
                        viewPager.setCurrentItem(0);
                        bottomNavigationView.getMenu().findItem(R.id.menu_main).setChecked(true);
                       break;

                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_vs).setChecked(true);
                        break;

                    case 2:
                        textView = (TextView)findViewById(R.id.fragementset_NICKNAME);
                        //System.out.println(UserCacheInfo.NICK_NAME);
                        textView.setText(UserCacheInfo.NICK_NAME);
                        viewPager.setCurrentItem(2);
                        bottomNavigationView.getMenu().findItem(R.id.menu_set).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_main:
                        textView = (TextView)findViewById(R.id.fragmane_NICKNAME);
                        //System.out.println(UserCacheInfo.NICK_NAME);
                        textView.setText(UserCacheInfo.NICK_NAME);
                        textView2 = (TextView)findViewById(R.id.first_account_book_cash);
                        textView2.setText(UserCacheInfo.FIRST_ACCOUNT_BOOK_CASH);
                        viewPager.setCurrentItem(0);
                        break;


                    case R.id.menu_vs:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.menu_set:
                        textView = (TextView)findViewById(R.id.fragementset_NICKNAME);
                        //System.out.println(UserCacheInfo.NICK_NAME);
                        textView.setText(UserCacheInfo.NICK_NAME);
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

    }
}