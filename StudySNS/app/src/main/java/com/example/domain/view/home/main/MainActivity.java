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
import android.view.WindowManager;
import android.widget.Space;

import com.example.domain.view.home.setting.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Space status_bar_space;

    private int statusBarHeight;

    private BottomNavigationView bottomNavigationView;

    private FragmentContainerView main_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar tb = (Toolbar) findViewById(R.id.toolbar) ;
//        tb.setBackgroundColor(Color.WHITE);
//        tb.setTitleTextColor(Color.BLACK);

//        tb.setOnClickListener();
//        setSupportActionBar(tb) ;

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        this.statusBarHeight = 0;
        int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resId>0){
            this.statusBarHeight = getResources().getDimensionPixelSize(resId);
        }

        this.status_bar_space = findViewById(R.id.status_bar_space);

        this.status_bar_space.getLayoutParams().height = statusBarHeight;

        this.bottomNavigationView = findViewById(R.id.bottomNavigationView);

        this.main_fragment = findViewById(R.id.main_fragment);

        this.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeBTN:
                        Navigation.findNavController(main_fragment).navigate(R.id.action_homeFragment_to_loginFragment);
                        break;
                    case R.id.communityBTN:
//                        Navigation.findNavController(main_fragment).navigate(R.id.action_homeFragment_to_settingsFragment);
                        break;
                    case R.id.plannerBTN:
//                        Navigation.findNavController(main_fragment).navigate(R.id.action_homeFragment_to_loginFragment);
                        break;
                    case R.id.settingBTN:
                        Navigation.findNavController(main_fragment).navigate(R.id.action_homeFragment_to_settingsFragment);
                        break;
                }
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);

        return super.onCreateOptionsMenu(menu);
    }
}