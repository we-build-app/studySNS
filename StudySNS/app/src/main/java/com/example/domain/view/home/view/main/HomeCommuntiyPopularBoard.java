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

public class HomeCommuntiyPopularBoard extends Fragment {
    private ArrayList<HomeCommunityPopularBoardRecycleritem> list = new ArrayList<HomeCommunityPopularBoardRecycleritem>();
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView popularBoardRecycler = view.findViewById(R.id.PopularBoard_Recycler);
        HomeCommunityPopularBoardRecyclerAdapter HPBrecycleritemAdapter = new HomeCommunityPopularBoardRecyclerAdapter(this.list);
        popularBoardRecycler.setAdapter(HPBrecycleritemAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        popularBoardRecycler.setLayoutManager(linearLayoutManager);

        Uri sampleURI = Uri.parse("https://www.google.com/search?q=%EC%BA%90%EB%A6%AD%ED%84%B0&sxsrf=APq-WBsQpwGE-3uB3IXYRLTnhUQMC_Hpxw:1650946268575&source=lnms&tbm=isch&sa=X&sqi=2&ved=2ahUKEwjeq4aP7rD3AhVMgpUCHW2LATkQ_AUoAXoECAIQAw&biw=1920&bih=929&dpr=1#imgrc=D5ifACO2Yw3RIM");
        addRecyclerItem(sampleURI, "홍길동", "04/26", "수터디", "안녕하세요 만나서 반갑습니다", "40", "10");
        HPBrecycleritemAdapter.notifyDataSetChanged();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_communtiy_popular_board, container, false);
        return view;
    }

    private void addRecyclerItem(Uri profile, String username, String date, String title, String Description, String likenum, String replynum){
        HomeCommunityPopularBoardRecycleritem HCPRecycler = new HomeCommunityPopularBoardRecycleritem();
        HCPRecycler.setPopluarBoard_profile(profile);
        HCPRecycler.setPopluarBoard_username(username);
        HCPRecycler.setPopluarBoard_date(date);
        HCPRecycler.setPopluarBoard_Article_title(title);
        HCPRecycler.setPopluarBoard_Article_description(Description);
        HCPRecycler.setPopluarBoard_Article_likenum(likenum);
        HCPRecycler.setPopluarBoard_Article_replynum(replynum);
        list.add(HCPRecycler);
    }
}