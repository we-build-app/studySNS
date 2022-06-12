package com.softcon.studysns.view.home.setting;

import androidx.fragment.app.FragmentContainerView;

import android.view.View;

import com.softcon.studysns.asset.domain.AbstractFragment;

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