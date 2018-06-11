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

import com.quizapp.jitcodez.quizapp.Adapters.SubSectionAdapter;
import com.quizapp.jitcodez.quizapp.Adapters.TheoryAdapter;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Subsection;
import com.quizapp.jitcodez.quizapp.database.Theory;

import java.util.ArrayList;

public class SubsectionFragment extends Fragment {
    public SubsectionFragment(){

    }
    RecyclerView rc;
    ArrayList<Subsection> sub;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_subsection, container, false);
                sub=getArguments().getParcelableArrayList("subsectionList");
        rc = (RecyclerView) root.findViewById(R.id.rc_theory_view_subsection);
        SubSectionAdapter theoryAdapter = new SubSectionAdapter(getContext(), sub);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setItemAnimator(new DefaultItemAnimator());
        rc.setAdapter(theoryAdapter);
        return root;

    }
}
