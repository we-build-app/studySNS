package com.softcon.studysns.view.home.view.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.softcon.asset.domain.AbstractFragment;
import com.softcon.studysns.view.home.view.MainActivity;
import com.softcon.studysns.view.home.setting.R;

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
//        this.login_loginButton.setOnClickListener(v -> this.navigateTo(R.id.action_global_homeFragment));
        this.login_loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그인 조건
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        this.login_idFindButton.setOnClickListener(v -> this.navigateTo(R.id.action_loginFragment_to_loginIDFind2));
        this.login_pwFindButton.setOnClickListener(v -> this.navigateTo(R.id.action_loginFragment_to_loginPWFind2));
        this.login_accountCreateButton.setOnClickListener(v -> this.navigateTo(R.id.action_loginFragment_to_loginAccountCreate2));
    }
}
