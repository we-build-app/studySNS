package com.example.domain.view.home.login;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.domain.view.home.setting.R;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class LoginAccountCreateFragment extends Fragment {
    // Associate
        // View
        private Button signInButton;
        private EditText name, userID, password, Repassword, Email, college;
        private TextView Uptosix, passwordCombination;
        private Boolean Blank, maxlength, passwordCondition;

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
        this.Uptosix = view.findViewById(R.id.editsixletterup);
        this.passwordCombination = view.findViewById(R.id.editcombination);

        this.Blank = false;
        this.maxlength = false;
        this.passwordCondition = false;

        //회원가입시 공백이 있는지 체크
        verfiyBlankIntheRegisterSection();

        this.password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //회원가입시 비밀번호가 조건에 충족하는지 체크
                verfiyPasswordConditionIntheRegisterSection();
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });


        // Set View Callback
//        this.signInButton.setOnClickListener(v-> Navigation.findNavController(view).navigate(R.id.action_global_homeFragment));
    }

    private void verfiyPasswordConditionIntheRegisterSection() {
        String PWinput = this.password.toString();
        //6자리 이상 체크
        if (password.getText().toString().length() >= 6) {
            this.Uptosix.setTextColor(0xAA4FC9FF);
            this.maxlength = true;
            //비밀번호 조합 체크
            if(Pattern.matches("^.*(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", PWinput)){
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else if(Pattern.matches("^.*(?=.*[a-zA-Z])(?=.*[0-9]).*$", PWinput)){
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else if(Pattern.matches("^.*(?=.*[0-9])(?=.*[!@#$%^&+=]).*$", PWinput)){
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else if(Pattern.matches("^.*(?=^.{8,20}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", PWinput)){
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else {
                this.passwordCombination.setTextColor(0xAA000000);
            }

        } else if(password.getText().toString().length() < 6){
            this.Uptosix.setTextColor(0xAA000000);
        }
    }


    private void verfiyBlankIntheRegisterSection() {
        this.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(getContext(),"이름를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
                else if(userID.getText().toString().equals("")){
                    Toast.makeText(getContext(),"아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    userID.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if(password.getText().toString().equals("")){
                    Toast.makeText(getContext(),"비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if(userID.getText().toString().equals("")){
                    Toast.makeText(getContext(),"아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    userID.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if(Email.getText().toString().equals("")){
                    Toast.makeText(getContext(),"이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    Email.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

                } else if(college.getText().toString().equals("")){
                    Toast.makeText(getContext(),"대학교를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    college.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                }
            }
        });
    }
}
