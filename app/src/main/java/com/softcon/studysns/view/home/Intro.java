package com.softcon.studysns.view.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.softcon.studysns.view.home.setting.R;

public class Intro extends AppCompatActivity {
    TextView title2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        title2 = findViewById(R.id.intro_title2);
        Animation animTreanTop = AnimationUtils.loadAnimation(getApplication(), R.anim.top);
        title2.startAnimation(animTreanTop);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Intro.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1800);
    }
}