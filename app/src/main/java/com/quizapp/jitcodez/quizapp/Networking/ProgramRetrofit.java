package com.quizapp.jitcodez.quizapp.Networking;

import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Program;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProgramRetrofit {
    @GET("GetProgram.php")
    Call<List<Program>> getProgramList();
}
