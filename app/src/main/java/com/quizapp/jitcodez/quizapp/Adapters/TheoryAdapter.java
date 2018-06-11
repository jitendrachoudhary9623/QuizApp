package com.quizapp.jitcodez.quizapp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.Activity.MainActivity;
import com.quizapp.jitcodez.quizapp.Activity.TabActivity;
import com.quizapp.jitcodez.quizapp.Fragments.SectionFragment;
import com.quizapp.jitcodez.quizapp.Fragments.SubsectionFragment;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Theory;

import java.util.ArrayList;
import java.util.List;

public class TheoryAdapter extends RecyclerView.Adapter<TheoryAdapter.TheoryViewHolder>{

    List<Theory> theoryList;
    Context cntx;

    public TheoryAdapter(Context cntx,List<Theory> theoryList){
        this.cntx=cntx;
        this.theoryList=theoryList;
    }
    @NonNull
    @Override
    public TheoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(cntx).inflate(R.layout.rc_theory,parent,false);
        TheoryAdapter.TheoryViewHolder viewHolder=new TheoryAdapter.TheoryViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TheoryViewHolder holder, final int position) {
holder.bind(position);
holder.title.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Bundle arguments = new Bundle();
        arguments.putParcelableArrayList("subsectionList", (ArrayList<? extends Parcelable>) theoryList.get(position).getSubsections());
        SubsectionFragment frag=new SubsectionFragment();
        frag.setArguments(arguments);
        FragmentManager fm =  ((TabActivity) cntx).getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.sub_section_holder, frag)
                .commit();

    }
});
    }

    @Override
    public int getItemCount() {
        return theoryList.size();
    }

    public class TheoryViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public TheoryViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.theory_title_1);
        }
        public void bind(final int position)
        {
            title.setText(""+theoryList.get(position).getSectionTitle());

        }
    }
}
