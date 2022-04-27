package com.example.domain.view.home.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.domain.view.home.setting.R;

public class LoginAccountCreateFragment extends Fragment {
    // Associate
        // View
        private Button signInButton;
        private EditText name, userID, password, Repassword, Email, college;

        // System
        private InputMethodManager inputMethodManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_account_create, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        // Associate View
        this.signInButton = view.findViewById(R.id.signInButton);
        this.name = view.findViewById(R.id.editName);
        this.userID = view.findViewById(R.id.editId);
        this.password = view.findViewById(R.id.editPw);
        this.Repassword = view.findViewById(R.id.editPwRe);
        this.Email = view.findViewById(R.id.editEmail);
        this.college = view.findViewById(R.id.editUniv);

        //회원가입시 공백이 있는지 체크
        verfiyBlankIntheRegisterSection();

        // Set View Callback
//        this.signInButton.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_global_homeFragment));
    }

    private void verfiyBlankIntheRegisterSection() {
        this.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(getContext(),"이름를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                }
                else if(userID.getText().toString().equals("")){
                    Toast.makeText(getContext(),"아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    userID.requestFocus();
                } else if(password.getText().toString().equals("")){
                    Toast.makeText(getContext(),"비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                } else if(userID.getText().toString().equals("")){
                    Toast.makeText(getContext(),"아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    userID.requestFocus();
                } else if(Email.getText().toString().equals("")){
                    Toast.makeText(getContext(),"이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    Email.requestFocus();
                } else if(college.getText().toString().equals("")){
                    Toast.makeText(getContext(),"대학교를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    college.requestFocus();
                }
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        });
    }
}
