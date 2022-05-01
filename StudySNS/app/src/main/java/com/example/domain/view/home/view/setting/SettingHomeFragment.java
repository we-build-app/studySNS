package com.example.domain.view.home.view.setting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asset.domain.AbstractFragment;
import com.example.domain.view.home.setting.R;

public class SettingHomeFragment extends AbstractFragment {

    private FragmentContainerView settingProfileZoneView;
    private FragmentContainerView settingsFragmentView;

    @Override
    protected int getViewId() {
        return R.layout.fragment_setting_home;
    }

    @Override
    protected void associateView(View view) {
        settingProfileZoneView = view.findViewById(R.id.settingProfileZoneView);
        settingsFragmentView = view.findViewById(R.id.settingsFragmentView);
    }

    @Override
    protected void initialize() {
        navigateTo(settingProfileZoneView, R.id.settingProfileZone);
        navigateTo(settingsFragmentView, R.id.settingsFragment);
    }
}