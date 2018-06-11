package com.quizapp.jitcodez.quizapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.Activity.InterviewActivity;
import com.quizapp.jitcodez.quizapp.Activity.ProgramActivity;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Program;

import java.util.ArrayList;
import java.util.List;

public class InterviewAdapter extends RecyclerView.Adapter<InterviewAdapter.InterviewViewHolder>{


    List<Interview> interviewList;
    Context cntx;
    /*
    1 for non tech
    2 for tech
     */
    public InterviewAdapter(Context cntx,List<Interview> interviewList){
        this.cntx=cntx;
        this.interviewList=interviewList;
    }
    @NonNull
    @Override
    public InterviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item= LayoutInflater.from(cntx).inflate(R.layout.rc_interview,parent,false);
        InterviewViewHolder viewHolder=new InterviewViewHolder(item);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull InterviewViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return interviewList.size();
    }

    public class InterviewViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        public InterviewViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.interview_title);

        }
        public void bind(final int position)
        {

            title.setText(""+interviewList.get(position).getInterviewQuestion());
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in=new Intent(cntx,InterviewActivity.class);
                    Interview p=interviewList.get(position);
                    in.putParcelableArrayListExtra("interview", (ArrayList<? extends Parcelable>) interviewList);
                    in.putExtra("interview_post",position);                    cntx.startActivity(in);
                }
            });
        }
    }
}
