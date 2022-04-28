package com.example.domain.view.home.login;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.domain.view.home.setting.R;


public class LoginAccoutCreateFindAddress extends Fragment implements View.OnClickListener {
    //주소 요청 코드
    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;

    private EditText Address;
    private Button GotoNickNameSet;
    private ImageView Goto_agree1, Goto_agree2, Goto_agree3;
    private CheckBox All_agree, Sub_agree1, Sub_agree2, Sub_agree3;
    private WebView addressAPI;

    private ConstraintLayout FadeIN;
    private Handler handler;

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
        this.FadeIN = view.findViewById(R.id.fadein);
        this.addressAPI = view.findViewById(R.id.AddressAPI);
        this.handler = new Handler();

        init_webView();

        this.Address.setFocusable(false);
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

    public void init_webView() {
        this.addressAPI.getSettings().setJavaScriptEnabled(true);
        this.addressAPI.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.addressAPI.addJavascriptInterface(new AndroidBridge(), "AddressAPI");
        this.addressAPI.setWebChromeClient(new WebChromeClient());
        this.addressAPI.loadUrl("file:///C:/Users/kyungsoo/public/index.html");
    }

    private class AndroidBridge {
        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Address.setText(String.format("%s %s", arg2, arg3));
                    init_webView();
                }
            });
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 주소 입력창 클릭시
            case R.id.Address_inputAddress:
                TakeDataFromAddressAPI(view);
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

    private void TakeDataFromAddressAPI(View view) {
        LoginAccountCreateAddressWebView AddressWeb = new LoginAccountCreateAddressWebView();
        int status = LoginAddressNetWorkStatus.getConnectivityStatus(getActivity().getApplicationContext());
        if(status == LoginAddressNetWorkStatus.TYPE_MOBILE || status == LoginAddressNetWorkStatus.TYPE_WIFI){
            this.GotoNickNameSet.setVisibility(view.INVISIBLE);
            this.FadeIN.setVisibility(view.VISIBLE);
            this.addressAPI.setVisibility(view.VISIBLE);
//            Navigation.findNavController(view).navigate(R.id.loginAccountCreateAddressWebView);
        } else{
            Toast.makeText(getContext(), "인터넷 연결을 확인해주세요", Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Bundle bundle){

    }

    private void CheckOtherConditionAndAgreement(View view) {
        //주소지 입력에 대해 체크하는 부분
        if(this.Address.getText().toString().equals("")){
            Toast.makeText(getContext(), "주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
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