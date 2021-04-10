package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.setting.R;

public class LoginPWFindFragment extends Fragment {

    // Associate
        // View
        private Button pwFindButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_pw_find, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Associate View
        this.pwFindButton = view.findViewById(R.id.pwFindButton);

        // Set View Callback
        this.pwFindButton.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_global_homeFragment));
    }
}
