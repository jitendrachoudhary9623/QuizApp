package com.quizapp.jitcodez.quizapp.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.QuizContract;
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
    TextView questionText;
    Button option_A,option_B,option_C,option_D;
    String marked_ans;
    String correct_ans;
    boolean check;
    MediaPlayer mediaPlayer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View root=  inflater.inflate(R.layout.fragment_question, container, false);
        questionList=getArguments().getParcelableArrayList("Questions");
        questionNo=getArguments().getInt(QuizContract.QuizEntry.QUESTION_NO)-1;
        Toast.makeText(getContext(),questionList.get(0).getQuestion(),Toast.LENGTH_LONG).show();

        questionText=(TextView)root.findViewById(R.id.question_text);
        option_A=(Button)root.findViewById(R.id.option_A);
        option_B=(Button)root.findViewById(R.id.option_B);
        option_C=(Button)root.findViewById(R.id.option_C);
        option_D=(Button)root.findViewById(R.id.option_D);

        QuizQuestion q=questionList.get(questionNo);
        questionText.setText(q.getQuestion());
        option_A.setText(q.getOptionA());
        option_B.setText(q.getOptionB());
        option_C.setText(q.getOptionC());
        option_D.setText(q.getOptionD());
        correct_ans=q.getCorrectAns();
        option_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked_ans="A";
                check=checkIfCorrect(correct_ans,marked_ans);
                if(check==false)
                {
                    option_A.setBackgroundColor(getResources().getColor(R.color.red));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.wrong_ans);
                    mediaPlayer.start();
                }
                else
                {
                    option_A.setBackgroundColor(getResources().getColor(R.color.blue));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.right_ans);
                    mediaPlayer.start();
                }
                option_B.setEnabled(false);
                option_C.setEnabled(false);
                option_D.setEnabled(false);
            }
        });


        option_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked_ans="B";
                check=checkIfCorrect(correct_ans,marked_ans);
                if(check==false)
                {
                    option_B.setBackgroundColor(getResources().getColor(R.color.red));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.wrong_ans);
                    mediaPlayer.start();
                }
                else
                {
                    option_B.setBackgroundColor(getResources().getColor(R.color.blue));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.right_ans);
                    mediaPlayer.start();
                }
                option_A.setEnabled(false);
                option_C.setEnabled(false);
                option_D.setEnabled(false);
            }
        });


        option_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked_ans="C";
                check=checkIfCorrect(correct_ans,marked_ans);
                if(check==false)
                {
                    option_C.setBackgroundColor(getResources().getColor(R.color.red));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.wrong_ans);
                    mediaPlayer.start();
                }
                else
                {
                    option_C.setBackgroundColor(getResources().getColor(R.color.blue));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.right_ans);
                    mediaPlayer.start();
                }
                option_B.setEnabled(false);
                option_A.setEnabled(false);
                option_D.setEnabled(false);
            }
        });


        option_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marked_ans="D";
                check=checkIfCorrect(correct_ans,marked_ans);
                if(check==false)
                {
                    option_D.setBackgroundColor(getResources().getColor(R.color.red));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.wrong_ans);
                    mediaPlayer.start();
                }
                else
                {
                    option_D.setBackgroundColor(getResources().getColor(R.color.blue));
                    mediaPlayer=MediaPlayer.create(getContext(),R.raw.right_ans);
                    mediaPlayer.start();
                }
                option_B.setEnabled(false);
                option_C.setEnabled(false);
                option_A.setEnabled(false);
            }
        });
        return root;
    }

    public boolean checkIfCorrect(String correct,String marked)
    {
    if(correct.equals(marked))
    {
        Toast.makeText(getContext(),"Right Answer",Toast.LENGTH_LONG).show();
                return true;
    }
    else
    {
        Toast.makeText(getContext(),"Wrong Answer",Toast.LENGTH_LONG).show();

        return false;
    }
    }
}
