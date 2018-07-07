package com.quizapp.jitcodez.quizapp.Fragments;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.quizapp.jitcodez.quizapp.Adapters.TheoryAdapter;
import com.quizapp.jitcodez.quizapp.Networking.TheoryRetrofit;
import com.quizapp.jitcodez.quizapp.Networking.ServiceBuilder;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.Utils.Constants;
import com.quizapp.jitcodez.quizapp.database.Theory;
import com.quizapp.jitcodez.quizapp.database.Theory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class TheoryFragment extends Fragment {

    List<Theory> rp ;
    SharedPreferences sharedpreferences ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_theory, container, false);

        sharedpreferences =  PreferenceManager.getDefaultSharedPreferences(getActivity());//getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        if(sharedpreferences.contains(Constants.Theory)){
            rp=getArrayList(Constants.Theory);

        }

        else {
            new TheoryList().execute();
            // Toast.makeText(getContext(),"New "+rp.size(),Toast.LENGTH_SHORT).show();
        }

        Bundle arguments = new Bundle();
        arguments.putParcelableArrayList("theoryList", (ArrayList<? extends Parcelable>) rp);
        SectionFragment frag=new SectionFragment();
        frag.setArguments(arguments);
        FragmentManager fm = getActivity().getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.section_holder, frag)
                .commit();

        return root;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rp=new ArrayList<Theory>();

    }

    public void saveArrayList(List<Theory> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<Theory> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<Theory>>() {}.getType();
        //  Toast.makeText(getContext(),"Loading from shared pref",Toast.LENGTH_SHORT).show();
        return gson.fromJson(json, type);
    }
    class TheoryList extends AsyncTask<Void, Void, List<Theory>> {
        List<Theory> master;

        @Override
        protected List<Theory> doInBackground(Void... voids) {
            int i = 0;
            Log.d("Theory", "" + (i++));
            TheoryRetrofit TheoryRequest = ServiceBuilder.buildService(TheoryRetrofit.class);
            Call<List<Theory>> caller = TheoryRequest.getTheoryList();
            Log.d("Theory", "" + (i++));

            try {
                Response<List<Theory>> newPostResponse = caller.execute();
                if (newPostResponse.isSuccessful()) {
                    rp =  newPostResponse.body();
                }


            } catch (IOException e) {

                e.printStackTrace();
            }
            Log.d("Theory", "" + (i++));

            return rp;
        }

        @Override
        protected void onPostExecute(List<Theory> Theorys) {
            super.onPostExecute(Theorys);
            if (Theorys != null) {
                rp= Theorys;
                saveArrayList(rp, Constants.Theory);
            }
        }

    }

}
