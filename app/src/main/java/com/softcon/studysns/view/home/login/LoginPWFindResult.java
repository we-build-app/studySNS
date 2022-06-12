package com.softcon.studysns.view.home.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softcon.studysns.view.home.setting.R;


public class LoginPWFindResult extends Fragment {

    private ImageView find_passowrd_result_back_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_pw_find_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.find_passowrd_result_back_btn = view.findViewById(R.id.find_password_result_back_btn);

        this.find_passowrd_result_back_btn.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginPWFind));
    }

}