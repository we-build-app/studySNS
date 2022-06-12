package com.softcon.studysns.view.home.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softcon.studysns.view.home.setting.R;

import java.util.ArrayList;

public class HomeCommuntiyAllBoardRecyclerAdapter extends RecyclerView.Adapter<HomeCommuntiyAllBoardRecyclerAdapter.viewHolder> {
    private ArrayList<HomeCommunityAllBoardRecycleritem> mData;
    private View view;

    public class viewHolder extends RecyclerView.ViewHolder{
        private ImageView AllBoard_profile;
        private TextView AllBoard_username;
        private TextView AllBoard_date;
        private Button AllBoard_report;
        private TextView AllBoard_Article_title;
        private TextView AllBoard_Article_description;
        private TextView AllBoard_Article_likenum;
        private TextView AllBoard_Article_replynum;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            AllBoard_profile = itemView.findViewById(R.id.AllBoard_profile);
            AllBoard_username = itemView.findViewById(R.id.AllBoard_username);
            AllBoard_date = itemView.findViewById(R.id.AllBoard_date);
            AllBoard_report = itemView.findViewById(R.id.AllBoard_report);
            AllBoard_Article_title = itemView.findViewById(R.id.AllBoard_articleTitle);
            AllBoard_Article_description = itemView.findViewById(R.id.AllBoard_articleDescription);
            AllBoard_Article_likenum = itemView.findViewById(R.id.AllBoard_articleLikeNum);
            AllBoard_Article_replynum = itemView.findViewById(R.id.AllBoard_articleReplyNum);

        }
    }
    HomeCommuntiyAllBoardRecyclerAdapter(ArrayList<HomeCommunityAllBoardRecycleritem> list) {this.mData = list;}

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        this.view = inflater.inflate(R.layout.recycleritem_allboard, parent, false) ;
        HomeCommuntiyAllBoardRecyclerAdapter.viewHolder vh = new HomeCommuntiyAllBoardRecyclerAdapter.viewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        HomeCommunityAllBoardRecycleritem HCArecycleritem = mData.get(position);
        Glide.with(this.view).load(HCArecycleritem.getAllBoard_profile()).into(holder.AllBoard_profile);
        holder.AllBoard_username.setText(HCArecycleritem.getAllBoard_username());
        holder.AllBoard_date.setText(HCArecycleritem.getAllBoard_date());
        holder.AllBoard_Article_title.setText(HCArecycleritem.getAllBoard_Article_title());
        holder.AllBoard_Article_description.setText(HCArecycleritem.getAllBoard_Article_description());
        holder.AllBoard_Article_likenum.setText(HCArecycleritem.getAllBoard_Article_likenum());
        holder.AllBoard_Article_replynum.setText(HCArecycleritem.getAllBoard_Article_replynum());
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
