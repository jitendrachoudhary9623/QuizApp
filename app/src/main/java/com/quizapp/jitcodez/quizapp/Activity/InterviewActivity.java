package com.quizapp.jitcodez.quizapp.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;

import java.util.List;

public class InterviewActivity extends AppCompatActivity {
    List<Interview> interviewList;
    TextView prev,next,ques,ans;
    Interview p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
       // final Interview p = (Interview) getIntent().getParcelableExtra("interview");
        interviewList=getIntent().getParcelableArrayListExtra("interview");
        int position=getIntent().getIntExtra("interview_post",0);

        next=(TextView)findViewById(R.id.interview_next);
        prev=(TextView)findViewById(R.id.interview_prev);
        ques=(TextView)findViewById(R.id.interview_question);
        ans=(TextView)findViewById(R.id.interview_answer);
        updateView(position);

    }
    public void updateView(final int position){
         p=interviewList.get(position);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int i = position-1;
                if(i<0)
                {
                    i=interviewList.size()-1;
                }
                ques.setText(p.getInterviewQuestion());

                updateView(i);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = position+1;
                if(i==interviewList.size())
                {
                    i=0;
                }
                ques.setText(p.getInterviewQuestion());

                updateView(i);
            }
        });
        final Context cnt=this;
        ques.setText(p.getInterviewQuestion());
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(cnt, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(cnt);
                }
                builder.setTitle("Output")
                        .setMessage(p.getInterviewAnswer())
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })

                        .show();
            }
        });
    }
}
