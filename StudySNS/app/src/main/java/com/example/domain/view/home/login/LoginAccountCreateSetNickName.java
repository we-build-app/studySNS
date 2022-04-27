package com.example.domain.view.home.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domain.view.home.setting.R;


public class LoginAccountCreateSetNickName extends Fragment  {

    private EditText NickName;
    private TextView TextSize;
    private Button CompleteBTN;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_account_create_set_nick_name, container, false);

        this.NickName = view.findViewById(R.id.nickinput);
        this.TextSize = view.findViewById(R.id.textsize);
        this.CompleteBTN = view.findViewById(R.id.RegisterComplete);

        NickName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = NickName.getText().toString();
                TextSize.setText(String.valueOf(input.length())+" / 10");
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        this.CompleteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NickName.getText().toString().equals("")){
                    Toast.makeText(getContext(), "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
//                else if(){
//                  //중복확인 체크 부분
//                }
                else{
                    Navigation.findNavController(view).navigate(R.id.loginFragment);
                }
            }
        });

        return view;
    }
}