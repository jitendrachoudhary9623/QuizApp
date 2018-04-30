package com.quizapp.jitcodez.quizapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.Adapters.ScoreBoard;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.MarkedAnswers;

import java.util.List;

public class ScoreActivity extends AppCompatActivity {
 RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        List<MarkedAnswers> ma=getIntent().getExtras().getParcelableArrayList("MARKED_ANS");
        rv=(RecyclerView)findViewById(R.id.answer_key);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(new LinearLayoutManager(this));
        ScoreBoard sb=new ScoreBoard(ma,this);
        rv.setAdapter(sb);
        int score=getIntent().getExtras().getInt("SCORE");
        TextView Score=(TextView)findViewById(R.id.scoreActivity_score);
        Score.setText("SCORE is :\n"+score);

    }
}
