package com.example.login;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.setting.R;

public class LoginFragment extends Fragment {

    // Associate
        // View
        private Button login_loginButton, login_idFindButton, login_pwFindButton, login_accountCreateButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Associate View
        this.login_loginButton = view.findViewById(R.id.login_loginButton);
        this.login_idFindButton = view.findViewById(R.id.login_idFindButton);
        this.login_pwFindButton = view.findViewById(R.id.login_pwFindButton);
        this.login_accountCreateButton = view.findViewById(R.id.login_accountCreateButton);

        this.login_loginButton.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_global_homeFragment);
        });
        this.login_idFindButton.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_loginIDFind);
        });
        this.login_pwFindButton.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_loginPWFind);
        });
        this.login_accountCreateButton.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_loginAccountCreate);
        });
    }

}
