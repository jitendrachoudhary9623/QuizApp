package com.quizapp.jitcodez.quizapp.Activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quizapp.jitcodez.quizapp.Fragments.QuestionFragment;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.QuizContract;
import com.quizapp.jitcodez.quizapp.database.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    List<QuizQuestion> questionList=new ArrayList<QuizQuestion>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        insertData();
        getQuestions();
        QuestionFragment fragment=new QuestionFragment();
        Bundle b=new Bundle();
        b.putInt(QuizContract.QuizEntry.QUESTION_NO,1);
        b.putParcelableArrayList("Questions", (ArrayList<? extends Parcelable>) questionList);
        fragment.setArguments(b);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.question_container, fragment)
                .commit();
    }

    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String correctAns;
    int id;
    int questionNo;
    
    
    public void insertData()
    {
        question="Which of the following is not OOPS concept in Java?";
        optionA=" a) Inheritance";
        optionB=" b) Encapsulation";
        optionC=" c) Polymorphism";
        optionD=" d) Compilation";
        correctAns="D";
        id=3;
        questionNo=1;



        ContentValues cv = new ContentValues();
        Uri uri = QuizContract.QuizEntry.CONTENT_URI;

        cv.put(QuizContract.QuizEntry.QUESTION, question);
        cv.put(QuizContract.QuizEntry.OPTION_A, optionA);
        cv.put(QuizContract.QuizEntry.OPTION_B, optionB);
        cv.put(QuizContract.QuizEntry.OPTION_C, optionC);
        cv.put(QuizContract.QuizEntry.OPTION_D, optionD);
        cv.put(QuizContract.QuizEntry.CORRECT_ANS, correctAns);
        cv.put(QuizContract.QuizEntry.QUESTION_NO, questionNo);
        cv.put(QuizContract.QuizEntry.QUESTION_ID, id);


        getContentResolver().insert(uri,
                cv);
    }

    void getQuestions()
    {
        Uri uri=QuizContract.QuizEntry.CONTENT_URI;


        Cursor cursor=getContentResolver().query(uri,null,null,null,null,null);
        // clearListData();

        QuizQuestion q=null;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                q=new QuizQuestion();
                q.setId(cursor.getInt(cursor.getColumnIndex(QuizContract.QuizEntry.QUESTION_ID)));
                q.setQuestionNo(cursor.getInt(cursor.getColumnIndex(QuizContract.QuizEntry.QUESTION_NO)));

                q.setQuestion(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.QUESTION)));
                q.setOptionA(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_A)));
                q.setOptionB(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_B)));
                q.setOptionC(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_C)));
                q.setOptionD(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_D)));
                q.setCorrectAns(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.CORRECT_ANS)));

                questionList.add(q);
                //   qData.add(q);
            }

        }


    }

}
