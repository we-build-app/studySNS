package com.example.domain.view.home.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.Navigation;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Space;

import com.example.asset.domain.AbstractActivity;
import com.example.domain.view.home.setting.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AbstractActivity {

    private Space status_bar_space;

    private BottomNavigationView bottomNavigationView;

    private FragmentContainerView main_fragment;

    @Override
    protected int getViewId() { return R.layout.activity_main; }

    @Override
    protected void associateView() {
        this.status_bar_space = findViewById(R.id.status_bar_space);
        this.bottomNavigationView = findViewById(R.id.bottomNavigationView);
        this.main_fragment = findViewById(R.id.main_fragment);
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
                        navigateTo(main_fragment, R.id.settingsFragment);
                        break;
                }
                return true;
            }
        });
    }
}