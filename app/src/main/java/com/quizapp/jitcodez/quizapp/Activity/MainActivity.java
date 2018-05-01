package com.quizapp.jitcodez.quizapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.quizapp.jitcodez.quizapp.Adapters.CategoryAdapter;
import com.quizapp.jitcodez.quizapp.Adapters.ScoreBoard;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Category;

import java.util.ArrayList;
import java.util.List;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {
    Button start_quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*start_quiz=(Button)findViewById(R.id.start_quiz);



        start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,QuizActivity.class);
                startActivity(i);
            }
        });*/

        RecyclerView rv=(RecyclerView)findViewById(R.id.rv_category);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        List<Category> categoryList=new ArrayList<Category>();
        categoryList.add(new Category("Data Types, Variables and Arrays"));
        categoryList.add(new Category("Operators and Control Statements"));
        categoryList.add(new Category("Java Environment & OOPS Concepts"));
        categoryList.add(new Category("Classes and Methods"));
        categoryList.add(new Category("Inheritance"));
        categoryList.add(new Category("String Handling"));
        categoryList.add(new Category("Exploring java.lang & java.io"));
        categoryList.add(new Category("Serialization & Networking"));
        categoryList.add(new Category("java.util – The Collections Framework"));
        categoryList.add(new Category("Exception Handling"));
        categoryList.add(new Category("Multithreading"));
        categoryList.add(new Category("Interfaces & Packages"));
        categoryList.add(new Category("Generics"));
        categoryList.add(new Category("Java Beans & JDBC"));
        categoryList.add(new Category("Java Server Technologies & Servlet"));

        CategoryAdapter categoryAdapter=new CategoryAdapter(categoryList,this);
        rv.setAdapter(categoryAdapter);

    }
}
