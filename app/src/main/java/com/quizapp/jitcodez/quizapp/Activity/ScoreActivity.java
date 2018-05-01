package com.quizapp.jitcodez.quizapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.Adapters.ScoreBoard;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.MarkedAnswers;

import java.util.List;

import hotchemi.android.rate.AppRate;

public class ScoreActivity extends AppCompatActivity {
 RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView rateus=(TextView)findViewById(R.id.RateUs);

        List<MarkedAnswers> ma=getIntent().getExtras().getParcelableArrayList("MARKED_ANS");
        rv=(RecyclerView)findViewById(R.id.answer_key);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(new LinearLayoutManager(this));
        ScoreBoard sb=new ScoreBoard(ma,this);
        rv.setAdapter(sb);
        int score=getIntent().getExtras().getInt("SCORE");
        TextView Score=(TextView)findViewById(R.id.scoreActivity_score);
        Score.setText("Score is :\n"+score);
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRateUs();
            }
        });
    }

    void displayRateUs()
    {
        AppRate.with(getApplicationContext()).showRateDialog(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
