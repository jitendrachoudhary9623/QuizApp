package com.quizapp.jitcodez.quizapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.quizapp.jitcodez.quizapp.Adapters.TheoryAdapter;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Theory;

import java.util.ArrayList;

public class SectionFragment extends Fragment {

    RecyclerView rc;
    ArrayList<Theory> th;
    public SectionFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragement_section, container, false);
       // th=new ArrayList<Theory>();
        th=getArguments().getParcelableArrayList("theoryList");
        if(th!=null) {
            Toast.makeText(getContext(), "Section " + th.size(), Toast.LENGTH_SHORT).show();

            rc = (RecyclerView) root.findViewById(R.id.rc_theory_view);
            TheoryAdapter theoryAdapter = new TheoryAdapter(getContext(), th);
            rc.setLayoutManager(new LinearLayoutManager(getContext()));
            rc.setItemAnimator(new DefaultItemAnimator());
            rc.setAdapter(theoryAdapter);
        }
        return root;

    }
}
