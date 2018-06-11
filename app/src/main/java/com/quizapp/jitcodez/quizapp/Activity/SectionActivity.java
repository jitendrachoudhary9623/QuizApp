package com.quizapp.jitcodez.quizapp.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Interview;
import com.quizapp.jitcodez.quizapp.database.Subsection;

import java.util.List;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class SectionActivity extends AppCompatActivity {
    TextView codeView ;
    List<Subsection> sectionList;
    TextView prev,next,section_title;
    Subsection p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        sectionList=getIntent().getParcelableArrayListExtra("subsections");
        int position=getIntent().getIntExtra("subsection_post",0);
        codeView = (TextView) findViewById(R.id.section_view);

        next=(TextView)findViewById(R.id.section_next);
        prev=(TextView)findViewById(R.id.section_prev);
        section_title=(TextView)findViewById(R.id.section_title);
        updateView(position);

    }

    public void updateView(final int position){
        p=sectionList.get(position);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = position-1;
                if(i<0)
                {
                    i=sectionList.size()-1;
                }

                updateView(i);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = position+1;
                if(i==sectionList.size())
                {
                    i=0;
                }

                updateView(i);
            }
        });
        final Context cnt=this;
        codeView.setText(p.getDetail());
        section_title.setText(p.getId()+" "+p.getTitle());
    }

}
