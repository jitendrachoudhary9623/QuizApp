package com.quizapp.jitcodez.quizapp.Networking;

import com.quizapp.jitcodez.quizapp.database.Interview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterviewRetrofit {
    @GET("GetInterview.php")
    Call<List<Interview>> getInterviewList();
}
