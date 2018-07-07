package com.quizapp.jitcodez.quizapp.Networking;

import com.quizapp.jitcodez.quizapp.database.Category;
import com.quizapp.jitcodez.quizapp.database.Interview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuizRetrofit {
    @GET("GetQuiz.php")
    Call<List<Category>> getCategoryList();
}
