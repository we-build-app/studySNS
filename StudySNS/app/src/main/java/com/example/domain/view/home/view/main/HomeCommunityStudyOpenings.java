package com.example.domain.view.home.view.main;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domain.view.home.setting.R;

import java.util.ArrayList;

public class HomeCommunityStudyOpenings extends Fragment {
    private ArrayList<HomeCommunityStudyOpeningsRecycleritem> list = new ArrayList<HomeCommunityStudyOpeningsRecycleritem>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView studyopeningRecycler = view.findViewById(R.id.studyopenings_recycler);
        HomeCommunityStudyOpeningsRecyclerAdapter HCSrecycleritemAdapter = new HomeCommunityStudyOpeningsRecyclerAdapter(this.list);
        studyopeningRecycler.setAdapter(HCSrecycleritemAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        studyopeningRecycler.setLayoutManager(linearLayoutManager);

        Uri sampleURI = Uri.parse("https://www.google.com/search?q=%EC%BA%90%EB%A6%AD%ED%84%B0&sxsrf=APq-WBsQpwGE-3uB3IXYRLTnhUQMC_Hpxw:1650946268575&source=lnms&tbm=isch&sa=X&sqi=2&ved=2ahUKEwjeq4aP7rD3AhVMgpUCHW2LATkQ_AUoAXoECAIQAw&biw=1920&bih=929&dpr=1#imgrc=D5ifACO2Yw3RIM");
        addRecyclerItem(sampleURI, "최경수", "C++ 스터디 장", "모집중", "프로그래밍", "C++스터디 모집합니다", "12:00 ~ 13:00", "05/01", "지원하기(0/5)");
        HCSrecycleritemAdapter.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_community_study_openings, container, false);
        return view;
    }

    private void addRecyclerItem(Uri profile, String username, String usernickname, String check, String type, String title, String time, String dday, String applybtn){
        HomeCommunityStudyOpeningsRecycleritem HCSRecycler = new HomeCommunityStudyOpeningsRecycleritem();
        HCSRecycler.setStudyopenings_profile(profile);
        HCSRecycler.setStudyopenings_username(username);
        HCSRecycler.setStudyopenings_usernickname(usernickname);
        HCSRecycler.setStudyopenings_Article_check(check);
        HCSRecycler.setStudyopenings_Article_type(type);
        HCSRecycler.setStudyopenings_Article_title(title);
        HCSRecycler.setStudyopenings_Article_time(time);
        HCSRecycler.setStudyopenings_Article_Dday(dday);
        HCSRecycler.setStudyopenings_Article_applyBtn(applybtn);
        list.add(HCSRecycler);

    }
}