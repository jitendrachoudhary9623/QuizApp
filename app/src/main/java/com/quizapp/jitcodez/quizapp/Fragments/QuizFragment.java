package com.quizapp.jitcodez.quizapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quizapp.jitcodez.quizapp.Adapters.CategoryAdapter;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Category;

import java.util.ArrayList;
import java.util.List;

public class QuizFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root=  inflater.inflate(R.layout.activity_main, container, false);

        RecyclerView rv=(RecyclerView)root.findViewById(R.id.rv_category);
        rv.setItemAnimator(new DefaultItemAnimator());
        Context cntx=getContext();
        rv.setLayoutManager(new GridLayoutManager(cntx,2));

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

        CategoryAdapter categoryAdapter=new CategoryAdapter(categoryList,cntx);
        rv.setAdapter(categoryAdapter);


        return root;
    }
}
