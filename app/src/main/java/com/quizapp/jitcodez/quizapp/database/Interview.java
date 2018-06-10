
package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Interview implements Parcelable
{

    @SerializedName("interview_id")
    @Expose
    private String interviewId;
    @SerializedName("interview_type")
    @Expose
    private String interviewType;
    @SerializedName("interview_question")
    @Expose
    private String interviewQuestion;
    @SerializedName("interview_answer")
    @Expose
    private String interviewAnswer;
    public final static Creator<Interview> CREATOR = new Creator<Interview>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Interview createFromParcel(Parcel in) {
            return new Interview(in);
        }

        public Interview[] newArray(int size) {
            return (new Interview[size]);
        }

    }
    ;

    protected Interview(Parcel in) {
        this.interviewId = ((String) in.readValue((String.class.getClassLoader())));
        this.interviewType = ((String) in.readValue((String.class.getClassLoader())));
        this.interviewQuestion = ((String) in.readValue((String.class.getClassLoader())));
        this.interviewAnswer = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Interview() {
    }

    /**
     * 
     * @param interviewType
     * @param interviewQuestion
     * @param interviewAnswer
     * @param interviewId
     */
    public Interview(String interviewId, String interviewType, String interviewQuestion, String interviewAnswer) {
        super();
        this.interviewId = interviewId;
        this.interviewType = interviewType;
        this.interviewQuestion = interviewQuestion;
        this.interviewAnswer = interviewAnswer;
    }

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getInterviewQuestion() {
        return interviewQuestion;
    }

    public void setInterviewQuestion(String interviewQuestion) {
        this.interviewQuestion = interviewQuestion;
    }

    public String getInterviewAnswer() {
        return interviewAnswer;
    }

    public void setInterviewAnswer(String interviewAnswer) {
        this.interviewAnswer = interviewAnswer;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(interviewId);
        dest.writeValue(interviewType);
        dest.writeValue(interviewQuestion);
        dest.writeValue(interviewAnswer);
    }

    public int describeContents() {
        return  0;
    }

}
