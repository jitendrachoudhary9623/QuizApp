package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;

public class MarkedAnswers implements Parcelable {
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getMarkedAns() {
        return markedAns;
    }

    public void setMarkedAns(String markedAns) {
        this.markedAns = markedAns;
    }

    public static Creator<MarkedAnswers> getCREATOR() {
        return CREATOR;
    }

    String question;
    int id;
    String correctAns;
    String markedAns;

    public MarkedAnswers(String question, int id, String correctAns, String markedAns) {
        this.question = question;
        this.id = id;
        this.correctAns = correctAns;
        this.markedAns = markedAns;
    }
    public MarkedAnswers(){

    }

    protected MarkedAnswers(Parcel in) {
        question = in.readString();
        id = in.readInt();

        correctAns = in.readString();
        markedAns = in.readString();
    }

    public static final Creator<MarkedAnswers> CREATOR = new Creator<MarkedAnswers>() {
        @Override
        public MarkedAnswers createFromParcel(Parcel in) {
            return new MarkedAnswers(in);
        }

        @Override
        public MarkedAnswers[] newArray(int size) {
            return new MarkedAnswers[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeInt(id);
        dest.writeString(correctAns);
        dest.writeString(markedAns);
    }
}
