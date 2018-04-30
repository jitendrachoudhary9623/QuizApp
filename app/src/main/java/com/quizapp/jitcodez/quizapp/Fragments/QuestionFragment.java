package com.quizapp.jitcodez.quizapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    public QuestionFragment() {
        // Required empty public constructor
    }

    List<QuizQuestion> questionList=new ArrayList<QuizQuestion>();
    int questionNo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View root=  inflater.inflate(R.layout.fragment_question, container, false);
        questionList=getArguments().getParcelableArrayList("Questions");
        Toast.makeText(getContext(),questionList.get(0).getQuestion(),Toast.LENGTH_LONG).show();
        return root;
    }

}
