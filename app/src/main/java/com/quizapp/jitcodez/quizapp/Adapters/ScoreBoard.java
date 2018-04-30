package com.quizapp.jitcodez.quizapp.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.MarkedAnswers;

import java.util.List;

public class ScoreBoard extends RecyclerView.Adapter<ScoreBoard.ScoreViewHolder> {

    List<MarkedAnswers> answerKey;
    Context mContext;
    public ScoreBoard() {

    }

    public ScoreBoard(List<MarkedAnswers> ans, Context context) {
        answerKey=ans;
        mContext = context;

    }


    @Override
    public ScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rc_answer_key, parent, false);
        ScoreViewHolder mv = new ScoreViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(final ScoreViewHolder holder, final int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return answerKey.size();
    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder  {

     TextView question,correct,marked;

        public ScoreViewHolder(View itemView) {
            super(itemView);
            question=(TextView)itemView.findViewById(R.id.rc_question);
            correct=(TextView)itemView.findViewById(R.id.rc_correct);
            marked=(TextView)itemView.findViewById(R.id.rc_user);
        }

        public void bindData(final int position) {
         MarkedAnswers ma=answerKey.get(position);
         question.setText(ma.getQuestion());
         correct.setText("Correct Answer "+ma.getCorrectAns());
         marked.setText("Your Answer "+ma.getMarkedAns());
         if(ma.getCorrectAns().equals(ma.getMarkedAns()))
         {
             marked.setTextColor(itemView.getResources().getColor(R.color.colorPrimary));
         }
         else
         {
             marked.setTextColor(itemView.getResources().getColor(R.color.red));

         }
        }



    }
}
