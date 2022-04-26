package com.example.domain.view.home.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domain.view.home.setting.R;
import com.google.android.material.tabs.TabLayout;

public class HomeCommuntiy extends Fragment {
    private TabLayout tabs;

    //탭 레이아웃
    private HomeCommnutiyAllBoard AllBoard;
    private HomeCommuntiyPopularBoard PopularBoard;
    private HomeCommunityStudyOpenings StudyOpenings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_communtiy, container, false);

        this.AllBoard = new HomeCommnutiyAllBoard();
        this.PopularBoard = new HomeCommuntiyPopularBoard();
        this.StudyOpenings = new HomeCommunityStudyOpenings();

        this.tabs = view.findViewById(R.id.hometabs);

        //탭 레이아웃 설정부분 - 탭 레이아웃 클릭시 Fragment를 바꾸는 코드
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.homeMain, this.AllBoard).commit();

        this.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                switch (position){
                    case 0:
                        AllBoard = new HomeCommnutiyAllBoard();
                        selected = AllBoard;
                        break;
                    case 1:
                        PopularBoard = new HomeCommuntiyPopularBoard();
                        selected = PopularBoard;
                        break;
                    case 2:
                        StudyOpenings = new HomeCommunityStudyOpenings();
                        selected = StudyOpenings;
                        break;
                }
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.homeMain, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }
}