package com.quizapp.jitcodez.quizapp.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.quizapp.jitcodez.quizapp.Adapters.CategoryAdapter;
import com.quizapp.jitcodez.quizapp.Networking.QuizRetrofit;
import com.quizapp.jitcodez.quizapp.Networking.ServiceBuilder;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.Utils.Constants;
import com.quizapp.jitcodez.quizapp.database.Category;
import com.quizapp.jitcodez.quizapp.database.Category;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class QuizFragment extends Fragment {
    RecyclerView rv;
    List<Category> categoryList;
    SharedPreferences sharedpreferences ;

    List<Category> rp = new ArrayList<Category>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root=  inflater.inflate(R.layout.activity_main, container, false);

        rv=(RecyclerView)root.findViewById(R.id.rv_category);
        rv.setItemAnimator(new DefaultItemAnimator());
        Context cntx=getContext();
        rv.setLayoutManager(new GridLayoutManager(cntx,2));

        List<Category> categoryList=new ArrayList<Category>();
   
//new CategoryList().execute();
        return root;
    }

    class CategoryList extends AsyncTask<Void, Void, List<Category>> {
        List<Category> master;

        @Override
        protected List<Category> doInBackground(Void... voids) {
            int i=0;
            Log.d("Category",""+(i++));
            QuizRetrofit CategoryRequest = ServiceBuilder.buildService(QuizRetrofit.class);
            Call<List<Category>> caller = CategoryRequest.getCategoryList();
            Log.d("Category",""+(i++));

            try {
                Response<List<Category>> newPostResponse = caller.execute();
                if (newPostResponse.isSuccessful()) {
                    rp = newPostResponse.body();
                }


            } catch (IOException e) {

                e.printStackTrace();
            }
            Log.d("Category",""+(i++));

            return rp;
        }

        @Override
        protected void onPostExecute(List<Category> Categorys) {
            super.onPostExecute(Categorys);
            if (Categorys != null) {
                setupRecyclerView(Categorys);
            }
        }

       

    }
    public void setupRecyclerView(List<Category> rp1) {
        rp = rp1;

        CategoryAdapter categoryAdapter=new CategoryAdapter(rp,getContext());
        rv.setAdapter(categoryAdapter);
        saveArrayList(rp, Constants.Quiz);
       // saveArrayList(nonTechCategoryList,"nonTechCategory");
        // setupRecyclerView(rp);
        //tech = new CategoryAdapter(getContext(), nonTechCategoryList);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedpreferences =  PreferenceManager.getDefaultSharedPreferences(getActivity());//getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedpreferences.contains(Constants.Quiz)){
            setupRecyclerView(getArrayList(Constants.Quiz));

        }
        else {
           Toast.makeText(getContext(),"The Theory part may take time to load from the server , so please be patient",Toast.LENGTH_SHORT).show();
            new CategoryList().execute();
        }

    }


    public void saveArrayList(List<Category> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<Category> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<Category>>() {}.getType();
     //   Toast.makeText(getContext(),"Category shared",Toast.LENGTH_SHORT).show();
        return gson.fromJson(json, type);
    }
}
