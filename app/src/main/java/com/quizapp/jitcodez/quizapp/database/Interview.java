package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;

public class Interview implements Parcelable {
    String title;
    String Question;
    String Company;
    String Answer;
    String code;

    protected Interview(Parcel in) {
        title = in.readString();
        Question = in.readString();
        Company = in.readString();
        Answer = in.readString();
        code = in.readString();
    }

    public static final Creator<Interview> CREATOR = new Creator<Interview>() {
        @Override
        public Interview createFromParcel(Parcel in) {
            return new Interview(in);
        }

        @Override
        public Interview[] newArray(int size) {
            return new Interview[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Interview() {

    }

    public Interview(String title, String question, String company, String answer, String code) {

        this.title = title;
        Question = question;
        Company = company;
        Answer = answer;
        this.code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(Question);
        dest.writeString(Company);
        dest.writeString(Answer);
        dest.writeString(code);
    }
}
