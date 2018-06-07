package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;

public class Theory implements Parcelable{
    String title;
    String introduction;
    String section1;
    String section2;
    String section3;
    String section4;
    String section5;

    protected Theory(Parcel in) {
        title = in.readString();
        introduction = in.readString();
        section1 = in.readString();
        section2 = in.readString();
        section3 = in.readString();
        section4 = in.readString();
        section5 = in.readString();
    }

    public static final Creator<Theory> CREATOR = new Creator<Theory>() {
        @Override
        public Theory createFromParcel(Parcel in) {
            return new Theory(in);
        }

        @Override
        public Theory[] newArray(int size) {
            return new Theory[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSection1() {
        return section1;
    }

    public void setSection1(String section1) {
        this.section1 = section1;
    }

    public String getSection2() {
        return section2;
    }

    public void setSection2(String section2) {
        this.section2 = section2;
    }

    public String getSection3() {
        return section3;
    }

    public void setSection3(String section3) {
        this.section3 = section3;
    }

    public String getSection4() {
        return section4;
    }

    public void setSection4(String section4) {
        this.section4 = section4;
    }

    public String getSection5() {
        return section5;
    }

    public void setSection5(String section5) {
        this.section5 = section5;
    }

    public Theory() {

    }

    public Theory(String title, String introduction, String section1, String section2, String section3, String section4, String section5) {

        this.title = title;
        this.introduction = introduction;
        this.section1 = section1;
        this.section2 = section2;
        this.section3 = section3;
        this.section4 = section4;
        this.section5 = section5;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(introduction);
        dest.writeString(section1);
        dest.writeString(section2);
        dest.writeString(section3);
        dest.writeString(section4);
        dest.writeString(section5);
    }
}
