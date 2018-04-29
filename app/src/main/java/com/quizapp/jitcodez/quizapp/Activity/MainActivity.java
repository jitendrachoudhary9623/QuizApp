package com.quizapp.jitcodez.quizapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.quizapp.jitcodez.quizapp.R;

public class MainActivity extends AppCompatActivity {
    Button start_quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_quiz=(Button)findViewById(R.id.start_quiz);



        start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,QuizActivity.class);
                startActivity(i);
            }
        });
    }
}
