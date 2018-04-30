package com.quizapp.jitcodez.quizapp.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class QuizContract {

    public static final String AUTHORITY="com.quizapp.jitcodez.quizapp";
    public static final Uri BASE_CONTENT_URI= Uri.parse("content://"+AUTHORITY);
    public static final String PATH="QUIZ";
    public static class QuizEntry implements BaseColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH).build();
        public static final String TABLE_NAME="QUIZ";
        public static final String QUESTION="question";
        public static final String OPTION_A="optionA";
        public static final String OPTION_B="optionB";
        public static final String OPTION_C="optionC";
        public static final String OPTION_D="optionD";
        public static final String CORRECT_ANS="correctAns";
        public static final String QUESTION_ID="id";
        public static final String QUESTION_NO="question_num";




    }
}