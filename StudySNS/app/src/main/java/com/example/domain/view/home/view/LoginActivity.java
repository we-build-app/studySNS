package com.example.domain.view.home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Space;

import com.example.asset.domain.AbstractActivity;
import com.example.domain.view.home.setting.R;

public class LoginActivity extends AbstractActivity {

    private Space status_bar_space;

    @Override
    protected int getViewId() { return R.layout.activity_login; }

    @Override
    protected void associateView() {
        this.status_bar_space = findViewById(R.id.status_bar_space);
    }

    @Override
    protected void initialize() {
        this.controlTopSpace(this.status_bar_space);
    }
}