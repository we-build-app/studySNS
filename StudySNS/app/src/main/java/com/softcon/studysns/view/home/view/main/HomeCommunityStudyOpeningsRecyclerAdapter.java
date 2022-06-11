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

public class HomeCommunityStudyOpeningsRecyclerAdapter extends RecyclerView.Adapter<HomeCommunityStudyOpeningsRecyclerAdapter.viewHolder>{
    private ArrayList<HomeCommunityStudyOpeningsRecycleritem> mData;
    private View view;

    public class viewHolder extends RecyclerView.ViewHolder{
        private ImageView StudyOpenings_profile;
        private TextView StudyOpenings_username;
        private TextView StudyOpenings_usernickname;
        private TextView StudyOpenings_check;
        private TextView StudyOpenings_type;
        private TextView StudyOpenings_Article_title;
        private TextView StudyOpenings_Article_time;
        private TextView StudyOpenings_Article_dday;
        private Button StudyOpenings_Article_applybtn;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            StudyOpenings_profile = itemView.findViewById(R.id.Studyopening_profile);
            StudyOpenings_username = itemView.findViewById(R.id.Studyopening_username);
            StudyOpenings_usernickname = itemView.findViewById(R.id.Studyopening_usernickname);
            StudyOpenings_check = itemView.findViewById(R.id.Studyopening_check);
            StudyOpenings_type = itemView.findViewById(R.id.Studyopening_Articletype);
            StudyOpenings_Article_title = itemView.findViewById(R.id.Studyopening_articleTitle);
            StudyOpenings_Article_time = itemView.findViewById(R.id.Studyopening_articletime);
            StudyOpenings_Article_dday = itemView.findViewById(R.id.Studyopening_Dday);
            StudyOpenings_Article_applybtn = itemView.findViewById(R.id.Studyopening_applybtn);

        }
    }
    HomeCommunityStudyOpeningsRecyclerAdapter(ArrayList<HomeCommunityStudyOpeningsRecycleritem> list) {this.mData = list;}

    @NonNull
    @Override
    public HomeCommunityStudyOpeningsRecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        this.view = inflater.inflate(R.layout.recycleritem_studyopenings, parent, false) ;
        HomeCommunityStudyOpeningsRecyclerAdapter.viewHolder vh = new HomeCommunityStudyOpeningsRecyclerAdapter.viewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCommunityStudyOpeningsRecyclerAdapter.viewHolder holder, int position) {
        HomeCommunityStudyOpeningsRecycleritem HCSrecycleritem = mData.get(position);
        Glide.with(this.view).load(HCSrecycleritem.getStudyopenings_profile()).into(holder.StudyOpenings_profile);
        holder.StudyOpenings_username.setText(HCSrecycleritem.getStudyopenings_username());
        holder.StudyOpenings_usernickname.setText(HCSrecycleritem.getStudyopenings_usernickname());
        holder.StudyOpenings_check.setText(HCSrecycleritem.getStudyopenings_Article_check());
        holder.StudyOpenings_type.setText(HCSrecycleritem.getStudyopenings_Article_type());
        holder.StudyOpenings_Article_time.setText(HCSrecycleritem.getStudyopenings_Article_time());
        holder.StudyOpenings_Article_dday.setText(HCSrecycleritem.getStudyopenings_Article_Dday());
        holder.StudyOpenings_Article_applybtn.setText(HCSrecycleritem.getStudyopenings_Article_applyBtn());
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
