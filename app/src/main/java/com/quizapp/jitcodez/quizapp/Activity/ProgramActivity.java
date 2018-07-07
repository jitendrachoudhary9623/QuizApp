package com.quizapp.jitcodez.quizapp.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Program;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.classifier.CodeProcessor;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class ProgramActivity extends AppCompatActivity {
    CodeView codeView ;
    TextView statement,output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
       // CodeProcessor.init(this);
        final Program p = (Program) getIntent().getParcelableExtra("program");
        codeView = (CodeView) findViewById(R.id.code_view);
        statement=(TextView)findViewById(R.id.program_statement);
output=(TextView)findViewById(R.id.program_output);
        statement.setText(p.getProgramStatement());
        final String code=p.getProgramCode();

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode(code)
                .withTheme(ColorTheme.MONOKAI));

       // codeView.getOptions().setTheme(ColorTheme.SOLARIZED_LIGHT);
        //codeView.setCode(code);
        final Context cnt=this;
        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(cnt, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(cnt);
                }
                builder.setTitle("Output")
                        .setMessage(p.getProgramOutput())
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        }).setNegativeButton("Copy Code", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("code122","This is ");
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("simple text", code);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getApplicationContext(), "String copied to Clipboard",
                                Toast.LENGTH_LONG).show();
                    }
                })

                        .show();
            }
        });
    }
}
