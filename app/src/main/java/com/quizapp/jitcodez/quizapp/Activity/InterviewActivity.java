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

public class InterviewActivity extends AppCompatActivity {

    TextView no,type,ques,ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);
        final Interview p = (Interview) getIntent().getParcelableExtra("interview");

        no=(TextView)findViewById(R.id.interview_question_no);
        type=(TextView)findViewById(R.id.interview_question_type);
        ques=(TextView)findViewById(R.id.interview_question);
        ans=(TextView)findViewById(R.id.interview_answer);
        no.setText(p.getInterviewId());
        String type1=p.getInterviewType();
        if(type1.equals("1"))
        {
            type.setText("HR/Aptitude Questions");
        }
        else
        {
            type.setText("Technical Questions");

        }
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
