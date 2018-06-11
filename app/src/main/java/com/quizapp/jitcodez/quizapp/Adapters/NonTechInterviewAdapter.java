package com.quizapp.jitcodez.quizapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.Activity.InterviewActivity;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;

import java.util.List;

public class NonTechInterviewAdapter extends RecyclerView.Adapter<NonTechInterviewAdapter.NonTechInterviewViewHolder>{


    List<Interview> interviewList;
    Context cntx;
    /*
    1 for non tech 
    2 for tech
     */
    public NonTechInterviewAdapter(Context cntx,List<Interview> interviewList){
        this.cntx=cntx;
        this.interviewList=interviewList;
    }
    @NonNull
    @Override
    public NonTechInterviewAdapter.NonTechInterviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item= LayoutInflater.from(cntx).inflate(R.layout.rc_non_tech ,parent,false);
        NonTechInterviewAdapter.NonTechInterviewViewHolder viewHolder=new NonTechInterviewAdapter.NonTechInterviewViewHolder(item);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull NonTechInterviewAdapter.NonTechInterviewViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return interviewList.size();
    }

    public class NonTechInterviewViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        public NonTechInterviewViewHolder(View itemView) {
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
            title.setText(""+interviewList.get(position).getInterviewQuestion());
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(cntx,InterviewActivity.class);
                    Interview p=interviewList.get(position);
                    in.putExtra("interview",p);
                    cntx.startActivity(in);
                }
            });
        }
    }
}
