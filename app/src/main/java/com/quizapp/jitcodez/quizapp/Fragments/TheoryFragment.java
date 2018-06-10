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

import com.quizapp.jitcodez.quizapp.Adapters.NonTechInterviewAdapter;
import com.quizapp.jitcodez.quizapp.Adapters.TheoryAdapter;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Theory;

import java.util.ArrayList;
import java.util.List;

public class TheoryFragment extends Fragment {
    RecyclerView rc;
    List<Theory> theoryList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_theory, container, false);
        theoryList=new ArrayList<Theory>();
        int a=0;

        while(a!=4){
            Theory p=new Theory("This is a Title  This is test","sd","ada","sad","go tio","dgs","dsf");
            theoryList.add(p);
            a++;
        }

        rc=root.findViewById(R.id.rc_theory_view);
        TheoryAdapter pg=new TheoryAdapter(getContext(),theoryList);
        rc.setAdapter(pg);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setItemAnimator(new DefaultItemAnimator());
/*

        rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        RecyclerView rc=(RecyclerView)root.findViewById(R.id.rc_theory_view_subsection);
                        List<Interview> techInterviewList=new ArrayList<Interview>();
                        int a=0;
                        Interview p1=new Interview(1,2,"Implement a Stack  ","");
                        techInterviewList.add(p1);
                        while(a!=4){
                            Interview p=new Interview(1,2,"Programming Question: Given A Program check the parenthisis of the code in minimum number of lines . The choice of language is yours ","");
                            techInterviewList.add(p);
                            p=new Interview(1,2,"Time complexity of Quick Sort","");
                            techInterviewList.add(p);
                            a++;
                        }
                        NonTechInterviewAdapter nonTech=new NonTechInterviewAdapter(getContext(),techInterviewList);

                        rc.setAdapter(nonTech);
                        rc.setLayoutManager(new LinearLayoutManager(getContext()));
                        rc.setItemAnimator(new DefaultItemAnimator());
                        rc.hasFixedSize();
                    }
                });
*/

        return root;
    }
}
