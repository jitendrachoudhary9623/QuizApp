package com.quizapp.jitcodez.quizapp.Fragments;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.quizapp.jitcodez.quizapp.Activity.ScoreActivity;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.MarkedAnswers;
import com.quizapp.jitcodez.quizapp.database.Quiz;
import com.quizapp.jitcodez.quizapp.database.QuizContract;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    public QuestionFragment() {
        // Required empty public constructor
    }

    List<Quiz> questionList=new ArrayList<Quiz>();
    List<MarkedAnswers> answersList=new ArrayList<>();
    int questionNo;
    TextView questionText,questionNumber,scoreText;
    Button option_A,option_B,option_C,option_D,next;
    String marked_ans;
    String correct_ans;
    int score=0;
    boolean check,flag=false;
    MediaPlayer mediaPlayer;
    MarkedAnswers ma;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      final View root=  inflater.inflate(R.layout.fragment_question, container, false);
        questionList=getArguments().getParcelableArrayList("Questions");
        questionNo=getArguments().getInt(QuizContract.QuizEntry.QUESTION_NO);
        score=getArguments().getInt("SCORE");
        Collections.shuffle(questionList,new Random(50));
       // Toast.makeText(getContext(),questionList.get(0).getQuestion(),Toast.LENGTH_LONG).show();
if(questionList.size()!=0) {
    questionText = (TextView) root.findViewById(R.id.question_text);
    questionNumber = (TextView) root.findViewById(R.id.question_no);
    scoreText = (TextView) root.findViewById(R.id.score);
    option_A = (Button) root.findViewById(R.id.option_A);
    option_B = (Button) root.findViewById(R.id.option_B);
    option_C = (Button) root.findViewById(R.id.option_C);
    option_D = (Button) root.findViewById(R.id.option_D);
    next = (Button) root.findViewById(R.id.next_question);

    scoreText.setText("" + score + "/" + (questionNo + 1));
    questionNumber.setText("Question " + (questionNo + 1));
    Quiz q = questionList.get(questionNo);
    questionText.setText(q.getQuestion());
    option_A.setText(q.getOptionA());
    option_B.setText(q.getOptionB());
    option_C.setText(q.getOptionC());
    option_D.setText(q.getOptionD());
    correct_ans = q.getAns();
    option_A.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag = true;
            marked_ans = "A";
            scoreText.setText("" + score + "/" + (questionNo + 1));
            ma = new MarkedAnswers();
            ma.setQuestion(questionText.getText().toString());
            ma.setMarkedAns(marked_ans+"\t"+option_A.getText().toString());
            ma.setCorrectAns(correct_ans+"\t"+getCorrect_ans(correct_ans));
            answersList.add(ma);
            check = checkIfCorrect(correct_ans, marked_ans);
            if (check == false) {
                option_A.setBackgroundColor(getResources().getColor(R.color.red));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.wrong_ans);
                mediaPlayer.start();
            } else {
                score++;
                scoreText.setText("" + score + "/" + (questionNo + 1));

                option_A.setBackgroundColor(getResources().getColor(R.color.blue));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.right_ans);
                mediaPlayer.start();
            }
            option_A.setEnabled(false);

            option_B.setEnabled(false);
            option_C.setEnabled(false);
            option_D.setEnabled(false);
        }
    });


    option_B.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag = true;
            scoreText.setText("" + score + "/" + (questionNo + 1));

            marked_ans = "B";
            ma = new MarkedAnswers();
            ma.setQuestion(questionText.getText().toString());
            ma.setMarkedAns(marked_ans+"\t"+option_B.getText().toString());
            ma.setCorrectAns(correct_ans+"\t"+getCorrect_ans(correct_ans));
            answersList.add(ma);
            check = checkIfCorrect(correct_ans, marked_ans);
            if (check == false) {
                option_B.setBackgroundColor(getResources().getColor(R.color.red));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.wrong_ans);
                mediaPlayer.start();
            } else {
                score++;
                scoreText.setText("" + score + "/" + (questionNo + 1));

                option_B.setBackgroundColor(getResources().getColor(R.color.blue));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.right_ans);
                mediaPlayer.start();
            }
            option_B.setEnabled(false);

            option_A.setEnabled(false);
            option_C.setEnabled(false);
            option_D.setEnabled(false);
        }
    });


    option_C.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag = true;
            scoreText.setText("" + score + "/" + (questionNo + 1));

            marked_ans = "C";
            ma = new MarkedAnswers();
            ma.setQuestion(questionText.getText().toString());
            ma.setMarkedAns(marked_ans+"\t"+option_C.getText().toString());
            ma.setCorrectAns(correct_ans+"\t"+getCorrect_ans(correct_ans));
            answersList.add(ma);

            check = checkIfCorrect(correct_ans, marked_ans);
            if (check == false) {
                option_C.setBackgroundColor(getResources().getColor(R.color.red));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.wrong_ans);
                mediaPlayer.start();
            } else {
                score++;
                scoreText.setText("" + score + "/" + (questionNo + 1));

                option_C.setBackgroundColor(getResources().getColor(R.color.blue));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.right_ans);
                mediaPlayer.start();
            }
            option_C.setEnabled(false);

            option_B.setEnabled(false);
            option_A.setEnabled(false);
            option_D.setEnabled(false);
        }
    });


    option_D.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            flag = true;
            scoreText.setText("" + score + "/" + (questionNo + 1));

            marked_ans = "D";
            ma = new MarkedAnswers();
            ma.setQuestion(questionText.getText().toString());
            ma.setMarkedAns(marked_ans+"\t"+option_D.getText().toString());
            ma.setCorrectAns(correct_ans+"\t"+getCorrect_ans(correct_ans));
            answersList.add(ma);
            check = checkIfCorrect(correct_ans, marked_ans);
            if (check == false) {
                option_D.setBackgroundColor(getResources().getColor(R.color.red));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.wrong_ans);
                mediaPlayer.start();
            } else {
                score++;
                scoreText.setText("" + score + "/" + (questionNo + 1));

                option_D.setBackgroundColor(getResources().getColor(R.color.blue));
                mediaPlayer = MediaPlayer.create(getContext(), R.raw.right_ans);
                mediaPlayer.start();
            }
            option_D.setEnabled(false);

            option_B.setEnabled(false);
            option_C.setEnabled(false);
            option_A.setEnabled(false);
        }
    });


    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (flag == true) {
                if (questionNo < questionList.size() - 1) {
                    option_A.setEnabled(true);
                    option_A.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                    option_B.setEnabled(true);
                    option_B.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


                    option_C.setEnabled(true);
                    option_C.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


                    option_D.setEnabled(true);
                    option_D.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                    questionNo++;

                    questionNumber.setText("Question " + (questionNo + 1));
                    Quiz q = questionList.get(questionNo);
                    questionText.setText(q.getQuestion());
                    option_A.setText(q.getOptionA());
                    option_B.setText(q.getOptionB());
                    option_C.setText(q.getOptionC());
                    option_D.setText(q.getOptionD());
                    correct_ans = q.getAns();
                } else {
                    //  next.setVisibility(View.INVISIBLE);
                    //  Bundle bundle=new Bundle();
                    //   bundle.putInt("SCORE",score);
                    //   bundle.putParcelableArrayList("MARKEDANS", (ArrayList<? extends Parcelable>) answersList);
                    Intent i = new Intent(getContext(), ScoreActivity.class);
                    i.putExtra("SCORE", score);
                    i.putExtra("MARKED_ANS", (ArrayList<? extends Parcelable>) answersList);
                    getContext().startActivity(i);
                }
            } else {
                Toast.makeText(getContext(), "Answer the Question", Toast.LENGTH_LONG).show();
            }
        }
    });
}
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

    public String getCorrect_ans(String ans)
    {
        switch (ans)
        {
            case "A":
                return option_A.getText().toString();
            case "B":
                return option_B.getText().toString();
            case "C":
                return option_C.getText().toString();
            case "D":
                return option_D.getText().toString();

        }
        return "";

    }
}
