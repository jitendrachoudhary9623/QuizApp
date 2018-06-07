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

import com.quizapp.jitcodez.quizapp.Adapters.ProgramAdapter;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramFragment extends Fragment {

    RecyclerView rc;
    List<Program> pgmList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_program, container, false);
        pgmList=new ArrayList<Program>();
        int a=0;
        pgmList.add(new Program("Java Program for addition of two numbers","","",""));
        pgmList.add(new Program("Java Program for addition of two numbers","","",""));

        while(a!=4){
            Program p=new Program("Write a Java Program fo showing the concurrency issues and their solution using multithreading and remote monitor interface with client server architecture","code1\n\rstatement1\n\r\r","12","55");
            pgmList.add(p);
            a++;
        }
        pgmList.add(new Program("Java Program for addition of two numbers","","",""));
        Program p=new Program("Write a Java Program fo showing the concurrency issues and their solution using multithreading and remote monitor interface with client server architecture","code1\n\rstatement1\n\r\r","12","55");
        pgmList.add(p);
        pgmList.add(new Program("Java Program for addition of two numbers","","",""));

        p=new Program("Write a Java Program fo showing the concurrency issues and their solution using multithreading and remote monitor interface with client server architecture","code1\n\rstatement1\n\r\r","12","55");
        pgmList.add(p);
        pgmList.add(new Program("Java Program for addition of two numbers","","",""));


        rc=root.findViewById(R.id.rc_program_view);
        ProgramAdapter pg=new ProgramAdapter(getContext(),pgmList);
        rc.setAdapter(pg);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setItemAnimator(new DefaultItemAnimator());
        rc.hasFixedSize();
        return root;
    }
}
