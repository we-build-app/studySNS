package com.example.domain.view.home.login;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asset.domain.AbstractFragment;
import com.example.domain.view.home.setting.R;

public class LoginFragment extends AbstractFragment {

    // Associate
        // View
        private Button login_loginButton;
        private TextView login_idFindButton, login_pwFindButton, login_accountCreateButton;

    @Override protected int getViewId() { return R.layout.fragment_login_home; }

    @Override
    protected void associateView(View view) {
        this.login_loginButton = view.findViewById(R.id.login_loginButton);
        this.login_idFindButton = view.findViewById(R.id.Login_IDFind);
        this.login_pwFindButton = view.findViewById(R.id.Login_Pwfind);
        this.login_accountCreateButton = view.findViewById(R.id.Login_join);
    }

    @Override
    protected void initialize() {
        this.login_loginButton.setOnClickListener(v -> this.navigateTo(R.id.action_global_homeFragment));
        this.login_idFindButton.setOnClickListener(v -> this.navigateTo(R.id.action_loginFragment_to_loginIDFind));
        this.login_pwFindButton.setOnClickListener(v -> this.navigateTo(R.id.action_loginFragment_to_loginPWFind));
        this.login_accountCreateButton.setOnClickListener(v -> this.navigateTo(R.id.action_loginFragment_to_loginAccountCreate));
    }
}
