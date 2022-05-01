package com.example.domain.view.home.view.main;

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
import com.example.domain.view.home.setting.R;

import java.util.ArrayList;

public class HomeCommunityPopularBoardRecyclerAdapter extends RecyclerView.Adapter<HomeCommunityPopularBoardRecyclerAdapter.viewHolder>  {
    private ArrayList<HomeCommunityPopularBoardRecycleritem> mData;
    private View view;

    public class viewHolder extends RecyclerView.ViewHolder{
        private ImageView PopularBoard_profile;
        private TextView PopularBoard_username;
        private TextView PopularBoard_date;
        private Button PopularBoard_report;
        private TextView PopularBoard_Article_title;
        private TextView PopularBoard_Article_description;
        private TextView PopularBoard_Article_likenum;
        private TextView PopularBoard_Article_replynum;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            PopularBoard_profile = itemView.findViewById(R.id.PopularBoard_profile);
            PopularBoard_username = itemView.findViewById(R.id.PopularBoard_username);
            PopularBoard_date = itemView.findViewById(R.id.PopularBoard_date);
            PopularBoard_report = itemView.findViewById(R.id.PopularBoard_report);
            PopularBoard_Article_title = itemView.findViewById(R.id.PopularBoard_articleTitle);
            PopularBoard_Article_description = itemView.findViewById(R.id.PopularBoard_articleDescription);
            PopularBoard_Article_likenum = itemView.findViewById(R.id.PopularBoard_articleLikeNum);
            PopularBoard_Article_replynum = itemView.findViewById(R.id.PopularBoard_articleReplyNum);

        }
    }
    HomeCommunityPopularBoardRecyclerAdapter(ArrayList<HomeCommunityPopularBoardRecycleritem> list) {this.mData = list;}

    @NonNull
    @Override
    public HomeCommunityPopularBoardRecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        this.view = inflater.inflate(R.layout.recycleritem_popularboard, parent, false) ;
        HomeCommunityPopularBoardRecyclerAdapter.viewHolder vh = new HomeCommunityPopularBoardRecyclerAdapter.viewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCommunityPopularBoardRecyclerAdapter.viewHolder holder, int position) {
        HomeCommunityPopularBoardRecycleritem HCPrecycleritem = mData.get(position);
        Glide.with(this.view).load(HCPrecycleritem.getPopluarBoard_profile()).into(holder.PopularBoard_profile);
        holder.PopularBoard_username.setText(HCPrecycleritem.getPopluarBoard_username());
        holder.PopularBoard_date.setText(HCPrecycleritem.getPopluarBoard_date());
        holder.PopularBoard_Article_title.setText(HCPrecycleritem.getPopluarBoard_Article_title());
        holder.PopularBoard_Article_description.setText(HCPrecycleritem.getPopluarBoard_Article_description());
        holder.PopularBoard_Article_likenum.setText(HCPrecycleritem.getPopluarBoard_Article_likenum());
        holder.PopularBoard_Article_replynum.setText(HCPrecycleritem.getPopluarBoard_Article_replynum());
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
