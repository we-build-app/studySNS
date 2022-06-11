package com.softcon.studysns.view.home.view;

import android.widget.Space;

import com.softcon.asset.domain.AbstractActivity;
import com.softcon.studysns.view.home.setting.R;

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