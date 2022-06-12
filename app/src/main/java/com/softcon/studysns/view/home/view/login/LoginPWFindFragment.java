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
import com.softcon.studysns.view.home.setting.databinding.FragmentLoginPwFindBinding;

public class LoginPWFindFragment extends Fragment {

    // Associate
        // View
        public FragmentLoginPwFindBinding pw_binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pw_binding = FragmentLoginPwFindBinding.inflate(inflater, container, false);
        return pw_binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set View Callback
        pw_binding.pwFindButton.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_loginPWFind_to_loginPWFindResult));
        pw_binding.FindPWIDText.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.loginIDFind));
        pw_binding.FindPWRegisterText.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.loginAccountCreate));
        pw_binding.findPasswordBackBtn.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginFragment));
    }
}
