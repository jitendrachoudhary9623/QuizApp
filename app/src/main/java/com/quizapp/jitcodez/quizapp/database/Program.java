package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;

public class Program implements Parcelable {
    String title;
    String code;
    String input;
    String output;

    protected Program(Parcel in) {
        title = in.readString();
        code = in.readString();
        input = in.readString();
        output = in.readString();
    }

    public static final Creator<Program> CREATOR = new Creator<Program>() {
        @Override
        public Program createFromParcel(Parcel in) {
            return new Program(in);
        }

        @Override
        public Program[] newArray(int size) {
            return new Program[size];
        }
    };

    public Program() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public static Creator<Program> getCREATOR() {
        return CREATOR;
    }

    public Program(String title, String code, String input, String output) {

        this.title = title;
        this.code = code;
        this.input = input;
        this.output = output;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(code);
        dest.writeString(input);
        dest.writeString(output);
    }
}
