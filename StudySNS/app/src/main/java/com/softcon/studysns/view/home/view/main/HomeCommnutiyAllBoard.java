package com.softcon.studysns.view.home.view.main;

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

import com.softcon.studysns.view.home.setting.R;

import java.util.ArrayList;

public class HomeCommnutiyAllBoard extends Fragment {
    private ArrayList<HomeCommunityAllBoardRecycleritem> list = new ArrayList<HomeCommunityAllBoardRecycleritem>();
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView AllBoardRecycler = view.findViewById(R.id.Allboard_Recycler);
        HomeCommuntiyAllBoardRecyclerAdapter HCArecycleritemAdapter = new HomeCommuntiyAllBoardRecyclerAdapter(this.list);
        AllBoardRecycler.setAdapter(HCArecycleritemAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        AllBoardRecycler.setLayoutManager(linearLayoutManager);

        Uri sampleURI = Uri.parse("https://www.google.com/search?q=%EC%BA%90%EB%A6%AD%ED%84%B0&sxsrf=APq-WBsQpwGE-3uB3IXYRLTnhUQMC_Hpxw:1650946268575&source=lnms&tbm=isch&sa=X&sqi=2&ved=2ahUKEwjeq4aP7rD3AhVMgpUCHW2LATkQ_AUoAXoECAIQAw&biw=1920&bih=929&dpr=1#imgrc=D5ifACO2Yw3RIM");
        addRecyclerItem(sampleURI, "최경수", "03/26", "인사글", "안녕하세요 만나서 반갑습니다", "30", "10");
        addRecyclerItem(sampleURI, "최경수", "03/26", "인사글", "안녕하세요 만나서 반갑습니다", "30", "10");
        addRecyclerItem(sampleURI, "최경수", "03/26", "인사글", "안녕하세요 만나서 반갑습니다", "30", "10");
        HCArecycleritemAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_home_commnutiy_all_board, container, false);
        return view;
    }

    private void addRecyclerItem(Uri profile, String username, String date, String title, String Description, String likenum, String replynum){
        HomeCommunityAllBoardRecycleritem HCARecycler = new HomeCommunityAllBoardRecycleritem();
        HCARecycler.setAllBoard_profile(profile);
        HCARecycler.setAllBoard_username(username);
        HCARecycler.setAllBoard_date(date);
        HCARecycler.setAllBoard_Article_title(title);
        HCARecycler.setAllBoard_Article_description(Description);
        HCARecycler.setAllBoard_Article_likenum(likenum);
        HCARecycler.setAllBoard_Article_replynum(replynum);
        list.add(HCARecycler);
    }
}