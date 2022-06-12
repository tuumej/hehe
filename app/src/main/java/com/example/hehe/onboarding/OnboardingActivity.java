package com.example.hehe.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hehe.R;
import com.example.hehe.Signup.LoginActivity;
import com.example.hehe.fragment.MainFragment;
import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class OnboardingActivity extends AppCompatActivity {

    Button sk_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        sk_btn=findViewById(R.id.button15);
        sk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        PaperOnboardingPage scr1 = new PaperOnboardingPage("우리 금수저는 아니잖아",
                "계획을 세워야해",
                Color.parseColor("#00ff0000"), R.drawable.meal_pay, R.drawable.ring1);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("월급날 아직 20일 남았다",
                "퍼가요~",
                Color.parseColor("#00ff0000"), R.drawable.logo, R.drawable.ring2);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("내돈내산?",
                "멈.춰",
                Color.parseColor("#00ff0000"), R.drawable.logo, R.drawable.ring3);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        //2. 화면을 온보드 프래그먼트에 넣는다.
        PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(elements);

        //3. 프래그먼트 화면설정 완료
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.containers, onBoardingFragment);
        fragmentTransaction.commit();



    }//onCreate

}//MainActivity