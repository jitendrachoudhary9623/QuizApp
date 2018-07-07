package com.quizapp.jitcodez.quizapp.Fragments;

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
import com.quizapp.jitcodez.quizapp.Adapters.ProgramAdapter;
import com.quizapp.jitcodez.quizapp.Networking.ProgramRetrofit;
import com.quizapp.jitcodez.quizapp.Networking.ServiceBuilder;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.Utils.Constants;
import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Program;
import com.quizapp.jitcodez.quizapp.database.Program;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class ProgramFragment extends Fragment {
    List<Program> rp = new ArrayList<Program>();

    RecyclerView rc;
    List<Program> pgmList;
    ProgramAdapter pg;
    SharedPreferences sharedpreferences ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_program, container, false);
        pgmList=new ArrayList<Program>();
        
        rc=root.findViewById(R.id.rc_program_view);
        
        return root;
    }
    
    public void setupRecycler(List<Program> pgmList){
        pg=new ProgramAdapter(getContext(),pgmList);
        rc.setAdapter(pg);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setItemAnimator(new DefaultItemAnimator());
        rc.hasFixedSize();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedpreferences =  PreferenceManager.getDefaultSharedPreferences(getActivity());//getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedpreferences.contains(Constants.Program)){
            setupRecycler(getArrayList(Constants.Program));

        }
        else {
            Toast.makeText(getContext(),"Getting",Toast.LENGTH_SHORT).show();
            new ProgramList().execute();
        }

    }


    public void saveArrayList(List<Program> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<Program> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<Program>>() {}.getType();
        Toast.makeText(getContext(),"Program shared",Toast.LENGTH_SHORT).show();
        return gson.fromJson(json, type);
    }

    class ProgramList extends AsyncTask<Void, Void, List<Program>> {
        List<Program> master;

        @Override
        protected List<Program> doInBackground(Void... voids) {
            int i=0;
            Log.d("Program",""+(i++));
            ProgramRetrofit ProgramRequest = ServiceBuilder.buildService(ProgramRetrofit.class);
            Call<List<Program>> caller = ProgramRequest.getProgramList();
            Log.d("Program",""+(i++));

            try {
                Response<List<Program>> newPostResponse = caller.execute();
                if (newPostResponse.isSuccessful()) {
                    rp = newPostResponse.body();
                    Log.d("Program",""+rp.toString());

                }


            } catch (IOException e) {

                e.printStackTrace();
            }
            Log.d("Program",""+(i++));

            return rp;
        }

        @Override
        protected void onPostExecute(List<Program> Programs) {
            super.onPostExecute(Programs);
            if (Programs != null) {

           //     Toast.makeText(getContext(),"Program not shared",Toast.LENGTH_SHORT).show();
                saveArrayList(Programs, Constants.Program);
                setupRecycler(Programs);
            }
        }

    }
}
