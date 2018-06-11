package com.quizapp.jitcodez.quizapp.Networking;

import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Theory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TheoryRetrofit {
    @GET("GetTheory.php")
    Call<List<Theory>> getTheoryList();
}
