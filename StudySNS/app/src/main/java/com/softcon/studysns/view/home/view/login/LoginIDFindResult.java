package com.softcon.studysns.view.home.view.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.softcon.studysns.view.home.setting.R;


public class LoginIDFindResult extends Fragment {

    private Button MoveToLoginButton;
    private TextView UserName, UserID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_id_find_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.MoveToLoginButton = view.findViewById(R.id.FindIDResult_TologinButton);
        this.UserName = view.findViewById(R.id.FindIDResult_username);
        this.UserID = view.findViewById(R.id.FindIDResult_userID);

        this.MoveToLoginButton.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginFragment));
    }
}