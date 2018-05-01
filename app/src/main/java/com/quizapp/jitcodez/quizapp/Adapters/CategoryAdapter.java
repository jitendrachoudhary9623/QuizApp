package com.quizapp.jitcodez.quizapp.Adapters;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.quizapp.jitcodez.quizapp.Activity.QuizActivity;
import com.quizapp.jitcodez.quizapp.R;
import com.quizapp.jitcodez.quizapp.database.Category;
import com.quizapp.jitcodez.quizapp.database.MarkedAnswers;
import com.quizapp.jitcodez.quizapp.database.QuizContract;
import com.quizapp.jitcodez.quizapp.database.QuizQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category> categoryList;
    List<QuizQuestion> questionList=new ArrayList<>();
    Context mContext;
    final String mypreference = "mypref";

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    public CategoryAdapter() {

    }

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        mContext = context;
        sharedpreferences = mContext.getApplicationContext().getSharedPreferences(mypreference, MODE_PRIVATE);

    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.rc_main, parent, false);
        CategoryViewHolder mv = new CategoryViewHolder(itemView);
        return mv;
    }

    @Override
    public void onBindViewHolder(final CategoryViewHolder holder, final int position) {
        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView category;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.rc_category);

        }

        public void bindData(final int position) {

            switch(position%5)
            {
                case 0:
                    category.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                    break;
                case 1:
                    category.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
                    break;
                case 2:
                    category.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
                    break;
                case 3:
                    category.setBackgroundColor(mContext.getResources().getColor(R.color.green1));
                    break;
                case 4:
                    category.setBackgroundColor(mContext.getResources().getColor(R.color.green2));
                    break;

            }
            Category c = categoryList.get(position);
            final String cat=c.getCategory();
            category.setText(cat);
            category.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String filename="";
                    switch (category.getText().toString()){
                        case "Data Types, Variables and Arrays":
                            filename="dataTypes.txt";
                            break;
                        case "Operators and Control Statements":
                            filename="operators.txt";

                            break;
                        case "Java Environment & OOPS Concepts":
                            filename="oops.txt";

                            break;
                        case "Classes and Methods":
                            filename="classes.txt";
                            break;

                        case "Inheritance":
                            filename="inheritance.txt";
                            break;
                        case "String Handling":
                            filename="string.txt";
                            break;
                        case "Exploring java.lang & java.io":
                            filename="io.txt";
                            break;
                        case "Serialization & Networking":
                            filename="serialization.txt";
                            break;
                        case "java.util – The Collections Framework":
                            filename="util.txt";
                            break;
                        case "Exception Handling":
                            filename="exception.txt";
                            break;
                        case "Multithreading":
                            filename="threading.txt";
                            break;
                        case "Interfaces & Packages":
                            filename="interfaces.txt";
                            break;
                        case "Generics":
                            filename="generics.txt";
                            break;
                        case "Java Beans & JDBC":
                            filename="jdbc.txt";
                            break;
                        case "Java Server Technologies & Servlet":
                            filename="jsp.txt";
                            break;


                    }
                    if(sharedpreferences.contains(cat))
                    {

                    }
                    else {
                        insertData(filename,cat);
                    }
                   // Toast.makeText(mContext,cat,Toast.LENGTH_LONG).show();
                    getQuestions(cat);
                    Intent i=new Intent(mContext, QuizActivity.class);
                    i.putParcelableArrayListExtra("questionList", (ArrayList<? extends Parcelable>) questionList);
                    mContext.startActivity(i);
                }
            });
        }


        public void insertData(String filename,String category)
        {
            editor = sharedpreferences.edit();
            editor.putBoolean(category, true);
            editor.commit();
            String fileContent="";
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(mContext.getAssets().open(filename), "UTF-8"));
                String mLine;
                while ((mLine = reader.readLine()) != null) {

                    if(mLine.contains("\\n")) {
                        mLine=mLine.replace("\\n","");
                        fileContent = fileContent + mLine + "\n";
                    }
                    else
                        fileContent=fileContent+mLine;

                }
            } catch (IOException e) {
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                    }
                }
            }

            String QE[]=fileContent.split("!!");
            for(int i=0;i<QE.length;i++)
            {
                String bracket[]=QE[i].split("]]");
                ContentValues cv = new ContentValues();
                Uri uri = QuizContract.QuizEntry.CONTENT_URI;
                int j=0;
                while(j<bracket.length) {
                    cv.put(QuizContract.QuizEntry.QUESTION_ID, bracket[j++]);
                    cv.put(QuizContract.QuizEntry.QUESTION_NO, bracket[j++]);

                    cv.put(QuizContract.QuizEntry.QUESTION, bracket[j++]);
                    cv.put(QuizContract.QuizEntry.OPTION_A, bracket[j++]);
                    cv.put(QuizContract.QuizEntry.OPTION_B, bracket[j++]);
                    cv.put(QuizContract.QuizEntry.OPTION_C, bracket[j++]);
                    cv.put(QuizContract.QuizEntry.OPTION_D, bracket[j++]);
                    cv.put(QuizContract.QuizEntry.CORRECT_ANS, bracket[j++]);

                    cv.put(QuizContract.QuizEntry.CATEGORY, category);


                    mContext.getContentResolver().insert(uri,
                            cv);
                }
            }
        }


        void getQuestions(String category)
        {
            Uri uri=QuizContract.QuizEntry.CONTENT_URI;
            Toast.makeText(mContext,category,Toast.LENGTH_LONG).show();

           // String selection = "category = \"" + category + "\"";
           // Toast.makeText(mContext,selection,Toast.LENGTH_LONG).show();

            Cursor cursor=mContext.getContentResolver().query(uri,null,QuizContract.QuizEntry.CATEGORY+" = ?",new String[] {category},null,null);
            // clearListData();
            questionList=null;
            QuizQuestion q=null;
            if (cursor.getCount() > 0) {
                questionList=new ArrayList<>();
                for (int i = 0; i < cursor.getCount(); i++) {
                    cursor.moveToPosition(i);
                    q=new QuizQuestion();
                    String c=cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.CATEGORY));
                    q.setId(cursor.getInt(cursor.getColumnIndex(QuizContract.QuizEntry.QUESTION_ID)));
                    q.setQuestionNo(cursor.getInt(cursor.getColumnIndex(QuizContract.QuizEntry.QUESTION_NO)));
                    q.setQuestion(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.QUESTION)));
                    q.setOptionA(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_A)));
                    q.setOptionB(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_B)));
                    q.setOptionC(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_C)));
                    q.setOptionD(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.OPTION_D)));
                    q.setCorrectAns(cursor.getString(cursor.getColumnIndex(QuizContract.QuizEntry.CORRECT_ANS)));
                    if(c.equals(category)) {
                        questionList.add(q);
                    }//   qData.add(q);
                }

            }


        }
    }
}
