package com.quizapp.jitcodez.quizapp.Networking;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static final String URL="http://www.jitendra.xyz/quiz/php/";
    private  static Retrofit.Builder builder=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit =builder.build();

    public static<S> S buildService(Class<S> serviceType)
    {
        return retrofit.create(serviceType);
    }
}