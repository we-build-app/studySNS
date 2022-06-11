package com.softcon.studysns.view.home.view.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.softcon.studysns.view.home.setting.R;

public class LoginPWFindFragment extends Fragment {

    // Associate
        // View
        private Button pw_find_btn;
        private TextView pw_id_text, pw_register_text;
        private ImageView pw_back_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_pw_find, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Associate View
        this.pw_find_btn = view.findViewById(R.id.pwFindButton);
        this.pw_id_text = view.findViewById(R.id.FindPW_IDText);
        this.pw_register_text = view.findViewById(R.id.FindPW_RegisterText);
        this.pw_back_btn = view.findViewById(R.id.find_password_back_btn);

        // Set View Callback
        this.pw_find_btn.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_loginPWFind_to_loginPWFindResult));
        this.pw_id_text.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.loginIDFind));
        this.pw_register_text.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.loginAccountCreate));
        this.pw_back_btn.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginFragment));
    }
}
