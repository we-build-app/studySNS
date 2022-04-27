package com.example.domain.view.home.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.domain.view.home.setting.R;


public class LoginAccoutCreateFindAddress extends Fragment implements View.OnClickListener {

    private EditText Address;
    private Button GotoNickNameSet;
    private ImageView Goto_agree1, Goto_agree2, Goto_agree3;
    private CheckBox All_agree, Sub_agree1, Sub_agree2, Sub_agree3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_accout_create_find_address, container, false);

        this.Address = view.findViewById(R.id.Address_inputAddress);
        this.GotoNickNameSet = view.findViewById(R.id.GotoNickNameSetting);
        this.All_agree = view.findViewById(R.id.Address_Allagree);
        this.Sub_agree1 = view.findViewById(R.id.Address_agree1);
        this.Sub_agree2 = view.findViewById(R.id.Address_agree2);
        this.Sub_agree3 = view.findViewById(R.id.Address_agree3);
        this.Goto_agree1 = view.findViewById(R.id.Goto_agree1);
        this.Goto_agree2 = view.findViewById(R.id.Goto_agree2);
        this.Goto_agree3 = view.findViewById(R.id.Goto_agree3);

        this.Address.setOnClickListener(this);
        this.GotoNickNameSet.setOnClickListener(this);
        this.All_agree.setOnClickListener(this);
        this.Sub_agree1.setOnClickListener(this);
        this.Sub_agree2.setOnClickListener(this);
        this.Sub_agree3.setOnClickListener(this);

        this.Goto_agree1.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginAccountCreateAgree1));
        this.Goto_agree1.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginAccountCreateAgree2));
        this.Goto_agree1.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.loginAccountCreateAgree3));
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 주소 입력창 클릭시
            case R.id.Address_inputAddress:
                break;
            // 다음으로 버튼 클릭시
            case R.id.GotoNickNameSetting:
                CheckOtherConditionAndAgreement(view);
                break;
                //약관 모두 동의하기 클릭시
            case R.id.Address_Allagree:
                CheckOtherAgreement();
                break;
        }
    }

    private void CheckOtherConditionAndAgreement(View view) {
        //주소지 입력에 대해 체크하는 부분
        if(this.Address.getText().toString().equals("")){
            Toast.makeText(getContext(), "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
            Address.requestFocus();
        }
        //약관 동의에 관해 체크하는 부분
        else if(!(Sub_agree1.isChecked()) || !(Sub_agree2.isChecked())){
            if(!(Sub_agree1.isChecked()) && !(Sub_agree2.isChecked())){
                Toast.makeText(getContext(), "필수 약관 모두 체크해주세요.", Toast.LENGTH_SHORT).show();
            } else if(!(Sub_agree1.isChecked())){
                Toast.makeText(getContext(), "이용약관 동의에 체크하지 않았습니다.", Toast.LENGTH_SHORT).show();
            } else if(!(Sub_agree2.isChecked())){
                Toast.makeText(getContext(), "개인정보수집 동의에 체크하지 않았습니다.", Toast.LENGTH_SHORT).show();
            }
        } else{
            if(!Sub_agree3.isChecked()){
                Toast.makeText(getContext(), "SNS/이메일 정보 수신에 비동의 하셨습니다", Toast.LENGTH_SHORT).show();
            }
            Navigation.findNavController(view).navigate(R.id.loginAccountCreateSetNickName);
        }
    }

    private void CheckOtherAgreement() {
        if(this.All_agree.isChecked()) {
            this.Sub_agree1.setChecked(true);
            this.Sub_agree2.setChecked(true);
            this.Sub_agree3.setChecked(true);
        } else{
            this.Sub_agree1.setChecked(false);
            this.Sub_agree2.setChecked(false);
            this.Sub_agree3.setChecked(false);
        }
    }


}