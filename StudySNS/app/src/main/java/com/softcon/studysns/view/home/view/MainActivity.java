package com.softcon.studysns.view.home.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Space;

import com.softcon.asset.domain.AbstractActivity;
import com.softcon.studysns.view.home.setting.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AbstractActivity {

    private Space status_bar_space;

    private FragmentContainerView main_fragment;

    private BottomNavigationView bottomNavigationView;

    private FloatingActionButton floatingActionButton;

    private FloatingActionButton floatingActionButtonOfCall;
    private FloatingActionButton floatingActionButtonOfVideo;
    private FloatingActionButton floatingActionButtonOfMessage;

    private ImageView half_circle_image;

    private boolean isFabOpen;

    @Override
    protected int getViewId() { return R.layout.activity_main; }

    @Override
    protected void associateView() {
        this.status_bar_space = findViewById(R.id.status_bar_space);
        this.main_fragment = findViewById(R.id.main_fragment);
        this.bottomNavigationView = findViewById(R.id.bottomNavigationView);
        this.floatingActionButton = findViewById(R.id.floatingActionButton);
        this.floatingActionButtonOfCall = findViewById(R.id.floatingActionButtonOfCall);
        this.floatingActionButtonOfVideo = findViewById(R.id.floatingActionButtonOfVideo);
        this.floatingActionButtonOfMessage = findViewById(R.id.floatingActionButtonOfMessage);
        this.half_circle_image = findViewById(R.id.half_circle_image);
    }

    @Override
    protected void initialize() {
        this.controlTopSpace(this.status_bar_space);
        this.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeBTN:
                        navigateTo(main_fragment, R.id.homeFragment);
                        break;
                    case R.id.communityBTN:
                        navigateTo(main_fragment, R.id.home_Communtiy);
                        break;
                    case R.id.plannerBTN:
//                        navigateTo(main_fragment, R.id.homeFragment);
                        break;
                    case R.id.settingBTN:
                        navigateTo(main_fragment, R.id.settingHomeFragment);
                        break;
                }
                return true;
            }
        });
        this.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFab();
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    private void toggleFab() {

        if (isFabOpen) {
            ObjectAnimator object = ObjectAnimator.ofFloat(floatingActionButton, "rotation", 0);
            object.setInterpolator(new LinearInterpolator());
            object.setDuration(500);
            object.start();
//            floatingActionButton.setBackgroundTintList();
//            floatingActionButton.setBackgroundColor(Color.RED);
            floatingActionButtonOfCall.setVisibility(View.GONE);
            floatingActionButtonOfVideo.setVisibility(View.GONE);
            floatingActionButtonOfMessage.setVisibility(View.GONE);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(79,201,255)));
                    floatingActionButton.setImageResource(R.drawable.star_btn);
                }
            }, 400);
            RotateAnimation ra = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f);
            ra.setDuration(500);
            ra.setFillAfter(true);
            half_circle_image.startAnimation(ra);

//            floatingActionButton.setImageResource(R.drawable.star_btn);

//            fab_sub1.startAnimation(fab_close);
//
//            fab_sub2.startAnimation(fab_close);
//
//            fab_sub1.setClickable(false);
//
//            fab_sub2.setClickable(false);

            isFabOpen = false;

        } else {
            ObjectAnimator object = ObjectAnimator.ofFloat(floatingActionButton, "rotation", 180);
            object.setInterpolator(new LinearInterpolator());
            object.setDuration(500);
            object.start();
//            floatingActionButton.setBackgroundColor(Color.RED);

//            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anim);
//            floatingActionButton.startAnimation(anim);
//            floatingActionButton.setRotation(90.0f);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    floatingActionButton.setImageResource(R.drawable.ic_baseline_close_24);
                    floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    floatingActionButtonOfCall.setVisibility(View.VISIBLE);
                    floatingActionButtonOfVideo.setVisibility(View.VISIBLE);
                    floatingActionButtonOfMessage.setVisibility(View.VISIBLE);
                }
            }, 400);
            RotateAnimation ra = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f);
            ra.setDuration(500);
            ra.setFillAfter(true);
            half_circle_image.startAnimation(ra);

//            floatingActionButton.setImageResource(R.drawable.ic_baseline_close_24);

//            fab_sub1.startAnimation(fab_open);
//
//            fab_sub2.startAnimation(fab_open);
//
//            fab_sub1.setClickable(true);
//
//            fab_sub2.setClickable(true);

            isFabOpen = true;

        }

    }
}