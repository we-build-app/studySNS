package com.softcon.asset.domain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.Navigation;

public abstract class AbstractFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(this.getViewId(), container, false);
    }
    protected abstract int getViewId();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.associateView(view);
        this.initialize();
    }
    protected abstract void associateView(View view);
    protected abstract void initialize();

    // Encapsulate
    protected void navigateTo(int destinationId) { Navigation.findNavController(this.getView()).navigate(destinationId); }
    protected void navigateTo(FragmentContainerView fragmentContainerView, int destinationId) { Navigation.findNavController(fragmentContainerView).navigate(destinationId); }
}
