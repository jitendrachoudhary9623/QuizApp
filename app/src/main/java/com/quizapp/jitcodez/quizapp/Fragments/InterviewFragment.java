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

import com.quizapp.jitcodez.quizapp.Adapters.InterviewAdapter;
import com.quizapp.jitcodez.quizapp.Adapters.ProgramAdapter;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Program;

import java.util.ArrayList;
import java.util.List;

public class InterviewFragment extends Fragment{
    RecyclerView rc;
    List<Interview> interviewList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_interview, container, false);
       interviewList=new ArrayList<Interview>();
        int a=0;
        while(a!=4){
            Interview p=new Interview("Solve Travelling Salesman problem in O(n) complexity for the give inputs","","","","");
            interviewList.add(p);
            a++;
        }

        rc=root.findViewById(R.id.rc_interview_view);
        InterviewAdapter pg=new InterviewAdapter(getContext(),interviewList);
        rc.setAdapter(pg);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setItemAnimator(new DefaultItemAnimator());
        rc.hasFixedSize();
        return root;
    }
    }
