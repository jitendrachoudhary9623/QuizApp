package com.quizapp.jitcodez.quizapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.Activity.ProgramActivity;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Program;

import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder> {

    List<Program> pgmList;
    Context cntx;

    public ProgramAdapter(Context cntx,List<Program> pgmList){
        this.cntx=cntx;
        this.pgmList=pgmList;
    }
    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item=LayoutInflater.from(cntx).inflate(R.layout.rc_program,parent,false);
        ProgramViewHolder viewHolder=new ProgramViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return pgmList.size();
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder{
        TextView counter;
        TextView title;
        public ProgramViewHolder(View itemView) {
            super(itemView);
            counter=(TextView)itemView.findViewById(R.id.program_no);
            title=(TextView)itemView.findViewById(R.id.program_title);
        }
        public void bind(final int position)
        {
            counter.setText(""+(position+1));
            title.setText(""+pgmList.get(position).getProgramStatement());
            title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(cntx,ProgramActivity.class);
                Program p=pgmList.get(position);
                in.putExtra("program",p);
                cntx.startActivity(in);
            }
        });
        }
    }
}
