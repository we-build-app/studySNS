package com.example.domain.view.home.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.domain.view.home.setting.R;

public class LoginPWFindFragment extends Fragment {

    // Associate
        // View
        private Button pwFindButton;
        private TextView IDFindText, RegisterText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_pw_find, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Associate View
        this.pwFindButton = view.findViewById(R.id.pwFindButton);
        this.IDFindText = view.findViewById(R.id.FindPW_IDText);
        this.RegisterText = view.findViewById(R.id.FindPW_RegisterText);

        // Set View Callback
        this.pwFindButton.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_loginPWFind_to_loginPWFindResult));
        this.IDFindText.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.loginIDFind));
        this.RegisterText.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.loginAccountCreate));
    }
}
