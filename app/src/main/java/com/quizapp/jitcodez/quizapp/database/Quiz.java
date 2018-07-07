
package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quiz implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("optionA")
    @Expose
    private String optionA;
    @SerializedName("optionB")
    @Expose
    private String optionB;
    @SerializedName("optionC")
    @Expose
    private String optionC;
    @SerializedName("optionD")
    @Expose
    private String optionD;
    @SerializedName("ans")
    @Expose
    private String ans;
    public final static Creator<Quiz> CREATOR = new Creator<Quiz>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Quiz createFromParcel(Parcel in) {
            return new Quiz(in);
        }

        public Quiz[] newArray(int size) {
            return (new Quiz[size]);
        }

    }
    ;

    protected Quiz(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.question = ((String) in.readValue((String.class.getClassLoader())));
        this.optionA = ((String) in.readValue((String.class.getClassLoader())));
        this.optionB = ((String) in.readValue((String.class.getClassLoader())));
        this.optionC = ((String) in.readValue((String.class.getClassLoader())));
        this.optionD = ((String) in.readValue((String.class.getClassLoader())));
        this.ans = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Quiz() {
    }

    /**
     * 
     * @param optionD
     * @param id
     * @param optionC
     * @param optionB
     * @param optionA
     * @param question
     * @param ans
     */
    public Quiz(String id, String question, String optionA, String optionB, String optionC, String optionD, String ans) {
        super();
        this.id = id;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.ans = ans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(question);
        dest.writeValue(optionA);
        dest.writeValue(optionB);
        dest.writeValue(optionC);
        dest.writeValue(optionD);
        dest.writeValue(ans);
    }

    public int describeContents() {
        return  0;
    }

}
