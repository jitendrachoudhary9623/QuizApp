
package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Program implements Parcelable
{

    @SerializedName("program_id")
    @Expose
    private String programId;
    @SerializedName("program_statement")
    @Expose
    private String programStatement;
    @SerializedName("program_code")
    @Expose
    private String programCode;
    @SerializedName("program_output")
    @Expose
    private String programOutput;
    public final static Creator<Program> CREATOR = new Creator<Program>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Program createFromParcel(Parcel in) {
            return new Program(in);
        }

        public Program[] newArray(int size) {
            return (new Program[size]);
        }

    }
    ;

    protected Program(Parcel in) {
        this.programId = ((String) in.readValue((String.class.getClassLoader())));
        this.programStatement = ((String) in.readValue((String.class.getClassLoader())));
        this.programCode = ((String) in.readValue((String.class.getClassLoader())));
        this.programOutput = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Program() {
    }

    /**
     * 
     * @param programStatement
     * @param programId
     * @param programCode
     * @param programOutput
     */
    public Program(String programId, String programStatement, String programCode, String programOutput) {
        super();
        this.programId = programId;
        this.programStatement = programStatement;
        this.programCode = programCode;
        this.programOutput = programOutput;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramStatement() {
        return programStatement;
    }

    public void setProgramStatement(String programStatement) {
        this.programStatement = programStatement;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramOutput() {
        return programOutput;
    }

    public void setProgramOutput(String programOutput) {
        this.programOutput = programOutput;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(programId);
        dest.writeValue(programStatement);
        dest.writeValue(programCode);
        dest.writeValue(programOutput);
    }

    public int describeContents() {
        return  0;
    }

}
