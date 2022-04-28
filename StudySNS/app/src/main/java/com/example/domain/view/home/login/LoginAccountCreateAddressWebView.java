package com.example.domain.view.home.login;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.domain.view.home.setting.R;

public class LoginAccountCreateAddressWebView extends Fragment {

    private WebView addressAPI;
    private NavController navController;
    private Handler handler;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_login_account_create_address_web_view, container, false);
        this.addressAPI = view.findViewById(R.id.AddressAPI);
        navController = NavHostFragment.findNavController(this);
        this.handler = new Handler();
        LoadingWebViewwithAddressAPI();
        return view;
    }

    private void LoadingWebViewwithAddressAPI() {
        this.addressAPI.getSettings().setJavaScriptEnabled(true);
        this.addressAPI.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.addressAPI.addJavascriptInterface(new AndroidBridge(), "AddressAPI");
        this.addressAPI.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // SSL 에러가 발생해도 계속 진행
                handler.proceed();
            }


            // 페이지 로딩 시작시 호출
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.e("페이지 시작", url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.e("페이지 로딩", url);
                addressAPI.loadUrl("javascript:sample2_execDaumPostcode();");
            }
        });

        //최초 웹뷰 로드
        this.addressAPI.loadUrl("https://studynet-studysns.web.app");
    }

    private class AndroidBridge {
        @JavascriptInterface
        public void processDATA(String data){
            // 다음(카카오) 주소 검색 API결과값이 브릿지 통로를 통해 전달 받음(from javascript)
            Log.e("주소값", data);
            Bundle bundle = new Bundle();
            bundle.putString("Address", data);
            Navigation.findNavController(view).navigate(R.id.loginAccoutCreateFindAddress);
            getActivity().finish();
        }
//        @JavascriptInterface
//        @SuppressWarnings("unused")
//        public void processDATA(String roadAdd) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    navController.getPreviousBackStackEntry().getSavedStateHandle().set("roadAddress", roadAdd);
//
//                }
//            });
//        }
//        public void processDATA(String data){
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("주소" + data);
//                    Address.setText(data);
////                    Address.setText(String.format("%s %s", arg2, arg3));
////                    init_webView();
//                }
//            });
//        }


    }
}