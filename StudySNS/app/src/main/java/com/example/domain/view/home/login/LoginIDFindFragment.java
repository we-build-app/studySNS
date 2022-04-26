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

public class LoginIDFindFragment extends Fragment {

    // Associate
        // View
        private Button idFindButton;
        private TextView FindPWText, RegisterText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_id_find, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Associate View
        this.idFindButton = view.findViewById(R.id.FIndID_FindButton);
        this.FindPWText = view.findViewById(R.id.FindID_PasswordText);
        this.RegisterText = view.findViewById(R.id.FindID_RegisterText);

        // Set View Callback
        this.idFindButton.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_loginIDFind_to_loginIDFindResult));
        this.FindPWText.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginPWFind));
        this.RegisterText.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginAccountCreate));
    }
}
