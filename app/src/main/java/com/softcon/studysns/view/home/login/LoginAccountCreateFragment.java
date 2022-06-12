package com.softcon.studysns.view.home.login;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
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

import com.softcon.studysns.view.home.setting.R;

import java.util.regex.Pattern;

public class LoginAccountCreateFragment extends Fragment {
    // Associate
    // View
    private Button signInButton;
    private EditText name, userID, password, Repassword, Email, college;
    private TextView Uptosix, passwordCombination, checkdouble;
    private Boolean maxlength, passwordCondition, duplication, checkEmail;
    private String PWinput, PwCheckinput;

    // System
    private InputMethodManager inputMethodManager;
    private Pattern pattern;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_account_create, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        this.pattern = Patterns.EMAIL_ADDRESS;
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
        this.checkdouble = view.findViewById(R.id.editcheckPWdouble);

        this.maxlength = false;
        this.passwordCondition = false;
        this.duplication = false;
        this.checkEmail = false;



        this.password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //회원가입시 비밀번호가 조건에 충족하는지 체크
                verfiyPasswordConditionIntheRegisterSection();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        this.Repassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //회원가입시 비밀번호와 재확인 비밀번호가 맞는지 체크
                checkPasswordwithOriginPassword();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        this.Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEmailForm();
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
        //회원가입시 공백이 있는지 체크
        verfiyBlankIntheRegisterSection();
        // Set View Callback

    }

    private void checkEmailForm() {
        if(pattern.matcher(Email.getText().toString()).matches()){
            this.checkEmail = true;
        } else{
            this.checkEmail = false;
        }
    }

    private void checkPasswordwithOriginPassword() {
        this.PwCheckinput = this.Repassword.getText().toString();
        if (this.PWinput != null) {
            if (this.PWinput.equals(this.PwCheckinput)) {
                this.checkdouble.setText("비밀번호가 일치합니다.");
                this.checkdouble.setTextColor(0xAA4FC9FF);
                this.duplication = true;
            } else if(this.PwCheckinput.equals("")){
                this.checkdouble.setText("비밀번호를 입력해주세요.");
                this.checkdouble.setTextColor(0xAA000000);
                this.duplication = false;
            } else {
                this.checkdouble.setText("비밀번호가 일치하지않습니다.");
                this.checkdouble.setTextColor(0xAAFF0000);
                this.duplication = false;
            }
        } else {
            this.checkdouble.setText("비밀번호를 입력해주세요.");
            this.checkdouble.setTextColor(0xAA000000);
            this.duplication = false;
        }

    }

    private void verfiyPasswordConditionIntheRegisterSection() {
        this.PWinput = this.password.getText().toString();
        //6자리 이상 체크
        if (this.PWinput.length() >= 6) {
            this.Uptosix.setTextColor(0xAA4FC9FF);
            this.maxlength = true;
            //비밀번호 조합 체크
            if (Pattern.matches("^.*(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", this.PWinput)) {
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else if (Pattern.matches("^.*(?=.*[a-zA-Z])(?=.*[0-9]).*$", this.PWinput)) {
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else if (Pattern.matches("^.*(?=.*[0-9])(?=.*[!@#$%^&+=]).*$", this.PWinput)) {
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else if (Pattern.matches("^.*(?=^.{8,20}$)(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", this.PWinput)) {
                this.passwordCombination.setTextColor(0xAA4FC9FF);
                this.passwordCondition = true;
            } else {
                this.passwordCombination.setTextColor(0xAA000000);
                this.passwordCondition = false;
            }

        } else if (this.PWinput.length() < 6) {
            this.Uptosix.setTextColor(0xAA000000);
            this.maxlength = false;
        }
    }


    private void verfiyBlankIntheRegisterSection() {
        this.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "이름를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if (userID.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    userID.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if (userID.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    userID.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if (Email.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    Email.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if(!pattern.matcher(Email.getText().toString()).matches()){
                    Toast.makeText(getContext(), "이메일 형식이 아닙니다.", Toast.LENGTH_SHORT).show();
                    Email.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else if (college.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "대학교를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    college.requestFocus();
                    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else{
                    System.out.println("길이 조건" + maxlength);
                    System.out.println("조합 조건" + passwordCondition);
                    System.out.println("재입력 조건" + duplication);
                    System.out.println("이메일 조건" + checkEmail);
                }
                if(maxlength && passwordCondition && duplication && checkEmail){
                    Navigation.findNavController(view).navigate(R.id.action_loginAccountCreate_to_loginAccoutCreateFindAddress);
                } else {
                    Toast.makeText(getContext(), "조건을 완성해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
