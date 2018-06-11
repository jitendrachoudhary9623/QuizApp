package com.quizapp.jitcodez.quizapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.Activity.InterviewActivity;
import com.quizapp.jitcodez.quizapp.Activity.MainActivity;
import com.quizapp.jitcodez.quizapp.Activity.SectionActivity;
import com.quizapp.jitcodez.quizapp.Fragments.SubsectionFragment;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Subsection;

import java.util.ArrayList;
import java.util.List;

public class SubSectionAdapter extends RecyclerView.Adapter<SubSectionAdapter.SubsectionViewHolder>{

    List<Subsection> SubsectionList;
    Context cntx;

    public SubSectionAdapter(Context cntx, List<Subsection> SubsectionList){
        this.cntx=cntx;
        this.SubsectionList=SubsectionList;
    }
    @NonNull
    @Override
    public SubsectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(cntx).inflate(R.layout.rc_non_tech,parent,false);
        SubSectionAdapter.SubsectionViewHolder viewHolder=new SubSectionAdapter.SubsectionViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubsectionViewHolder holder, final int position) {
holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return SubsectionList.size();
    }

    public class SubsectionViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public SubsectionViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.rc_category);
        }
        public void bind(final int position)
        {

            switch(position%5)
            {
                case 0:
                    title.setBackgroundColor(cntx.getResources().getColor(R.color.colorPrimaryDark));
                    break;
                case 1:
                    title.setBackgroundColor(cntx.getResources().getColor(R.color.colorPrimary));
                    break;
                case 2:
                    title.setBackgroundColor(cntx.getResources().getColor(R.color.colorAccent));
                    break;
                case 3:
                    title.setBackgroundColor(cntx.getResources().getColor(R.color.green1));
                    break;
                case 4:
                    title.setBackgroundColor(cntx.getResources().getColor(R.color.green2));
                    break;

            }

            title.setText(""+SubsectionList.get(position).getTitle());
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(cntx, SectionActivity.class);
                    Subsection p=SubsectionList.get(position);
                    in.putParcelableArrayListExtra("subsections", (ArrayList<? extends Parcelable>) SubsectionList);
                    in.putExtra("subsection_post",position);
                    cntx.startActivity(in);
                }
            });

        }
    }
}
