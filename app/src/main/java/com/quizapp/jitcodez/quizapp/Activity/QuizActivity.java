package com.quizapp.jitcodez.quizapp.Activity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.quizapp.jitcodez.quizapp.Fragments.QuestionFragment;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.QuizContract;
import com.quizapp.jitcodez.quizapp.database.QuizQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    public static final String mypreference = "mypref";
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    List<QuizQuestion> questionList=new ArrayList<QuizQuestion>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
       /* sharedpreferences = getApplicationContext().getSharedPreferences(mypreference, MODE_PRIVATE);
        if(sharedpreferences.contains("Init"))
        {

        }
        else {
            insertData();
        }
        getQuestions();*/
       questionList=getIntent().getParcelableArrayListExtra("questionList");
        QuestionFragment fragment=new QuestionFragment();
        Bundle b=new Bundle();
        b.putInt(QuizContract.QuizEntry.QUESTION_NO,0);
        b.putParcelableArrayList("Questions", (ArrayList<? extends Parcelable>) questionList);
        b.putInt("SCORE",0);
        fragment.setArguments(b);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.question_container, fragment)
                .commit();
    }

}
