package com.quizapp.jitcodez.quizapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.quizapp.jitcodez.quizapp.database.QuizContract.QuizEntry;
public class QuizHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="quiz.db";
    public static final int DATABASE_VERSION=4;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String CREATE_QUERY=" CREATE TABLE " + QuizEntry.TABLE_NAME
            +" ( "

            +QuizEntry.QUESTION_ID +" INTEGER NOT NULL PRIMARY KEY, "
            +QuizEntry.QUESTION_NO +" INTEGER NOT NULL , "

            +QuizEntry.QUESTION+" TEXT NOT NULL ,"
            +QuizEntry.OPTION_A+" TEXT NOT NULL ,"
            +QuizEntry.OPTION_B+" REAL NOT NULL ,"
            +QuizEntry.OPTION_C+" TEXT NOT NULL ,"
            +QuizEntry.OPTION_D+" TEXT NOT NULL ,"

            +QuizEntry.CORRECT_ANS+" TEXT NOT NULL "
            + " ) ;";
    public static final String DROP_QUERY="DROP TABLE IF EXISTS "+QuizEntry.TABLE_NAME+";";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_QUERY);
        db.execSQL(CREATE_QUERY);
    }
}
