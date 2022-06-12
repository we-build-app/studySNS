package com.softcon.studysns.asset.domain;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Space;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.Navigation;

import com.softcon.studysns.view.home.setting.R;

public abstract class AbstractActivity extends AppCompatActivity {

    private int statusBarHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getViewId());
        this.associateView();
        this.initialize();
    }
    protected abstract void associateView();
    protected abstract int getViewId();

    protected abstract void initialize();

    // Encapsulate
    protected void controlTopSpace(Space status_bar_space) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        this.statusBarHeight = 0;
        int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resId>0){
            this.statusBarHeight = getResources().getDimensionPixelSize(resId);
        }
        status_bar_space.getLayoutParams().height = statusBarHeight;
    }
    protected void navigateTo(FragmentContainerView fragmentContainerView, int destinationId) { Navigation.findNavController(fragmentContainerView).navigate(destinationId); }
}
