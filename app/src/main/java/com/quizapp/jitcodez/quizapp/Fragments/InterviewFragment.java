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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.quizapp.jitcodez.quizapp.Adapters.InterviewAdapter;
import com.quizapp.jitcodez.quizapp.Adapters.NonTechInterviewAdapter;
import com.quizapp.jitcodez.quizapp.Adapters.ProgramAdapter;
import com.quizapp.jitcodez.quizapp.Networking.InterviewRetrofit;
import com.quizapp.jitcodez.quizapp.Networking.ServiceBuilder;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Program;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class InterviewFragment extends Fragment {
    RecyclerView rc, rc2;
    List<Interview> techInterviewList, nonTechInterviewList;
    List<Interview> rp = new ArrayList<Interview>();
    InterviewAdapter tech;
    NonTechInterviewAdapter nonTech;
    SharedPreferences sharedpreferences ;// sharedpreferences = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);= getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_interview, container, false);
        techInterviewList = new ArrayList<Interview>();
        nonTechInterviewList = new ArrayList<Interview>();


        rc = root.findViewById(R.id.rc_interview_view_tech);
        rc2 = root.findViewById(R.id.rc_interview_view_non_tech);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedpreferences =  PreferenceManager.getDefaultSharedPreferences(getActivity());//getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
     //   if(savedInstanceState==null) {
        if(sharedpreferences.contains("techInterview")&&sharedpreferences.contains("nonTechInterview")){
            setupRecyclerViews(getArrayList("techInterview"),getArrayList("nonTechInterview"));

        }
        else {
            new InterviewList().execute();
        }
     //   }
      /*  else
        {
            rp.clear();
            rp=null; ArrayList<String> nonTech
            rp=savedInstanceState.getParcelableArrayList(Constants.RecipeList);
            setupRecyclerView(rp);
        }*/
    }


    public void saveArrayList(List<Interview> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<Interview> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<Interview>>() {}.getType();
        Toast.makeText(getContext(),"Loading from shared pref",Toast.LENGTH_SHORT).show();
        return gson.fromJson(json, type);
    }
    public void setupRecyclerViews(List<Interview> tech,List<Interview> nonTech)
    {

        InterviewAdapter tech1 = new InterviewAdapter(getContext(), nonTech);
        NonTechInterviewAdapter nonTech1 = new NonTechInterviewAdapter(getContext(), tech);

        rc.setAdapter(tech1);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setItemAnimator(new DefaultItemAnimator());
        rc.hasFixedSize();

        rc2.setAdapter(nonTech1);
        rc2.setLayoutManager(new LinearLayoutManager(getContext()));
        rc2.setItemAnimator(new DefaultItemAnimator());
        rc2.hasFixedSize();

    }
    class InterviewList extends AsyncTask<Void, Void, List<Interview>> {
        List<Interview> master;

        @Override
        protected List<Interview> doInBackground(Void... voids) {
            int i=0;
            Log.d("Interview",""+(i++));
            InterviewRetrofit InterviewRequest = ServiceBuilder.buildService(InterviewRetrofit.class);
            Call<List<Interview>> caller = InterviewRequest.getInterviewList();
            Log.d("Interview",""+(i++));

            try {
                Response<List<Interview>> newPostResponse = caller.execute();
                if (newPostResponse.isSuccessful()) {
                    rp = newPostResponse.body();
                }


            } catch (IOException e) {

                e.printStackTrace();
            }
            Log.d("Interview",""+(i++));

            return rp;
        }

        @Override
        protected void onPostExecute(List<Interview> Interviews) {
            super.onPostExecute(Interviews);
            if (Interviews != null) {
                setupRecyclerView(Interviews);
            }
        }

        public void setupRecyclerView(List<Interview> rp1) {
            rp = rp1;
            Interview i;
            for(int j=0;j<rp.size();j++)
            {
                i=rp.get(j);
                if(i.getInterviewType().equals("1")){
                    nonTechInterviewList.add(i);
                }
                else{
                    techInterviewList.add(i);
                }
            }
            saveArrayList(techInterviewList,"techInterview");
            saveArrayList(nonTechInterviewList,"nonTechInterview");
            setupRecyclerViews(techInterviewList,nonTechInterviewList);
                     //tech = new InterviewAdapter(getContext(), nonTechInterviewList);

        }

    }

}
