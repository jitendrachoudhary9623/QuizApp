
package com.quizapp.jitcodez.quizapp.database;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Theory implements Parcelable
{

    @SerializedName("section_id")
    @Expose
    private String sectionId;
    @SerializedName("section_title")
    @Expose
    private String sectionTitle;
    @SerializedName("subsections")
    @Expose
    private List<Subsection> subsections = null;
    public final static Creator<Theory> CREATOR = new Creator<Theory>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Theory createFromParcel(Parcel in) {
            return new Theory(in);
        }

        public Theory[] newArray(int size) {
            return (new Theory[size]);
        }

    }
    ;

    protected Theory(Parcel in) {
        this.sectionId = ((String) in.readValue((String.class.getClassLoader())));
        this.sectionTitle = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.subsections, (Subsection.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Theory() {
    }

    /**
     * 
     * @param subsections
     * @param sectionTitle
     * @param sectionId
     */
    public Theory(String sectionId, String sectionTitle, List<Subsection> subsections) {
        super();
        this.sectionId = sectionId;
        this.sectionTitle = sectionTitle;
        this.subsections = subsections;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public List<Subsection> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<Subsection> subsections) {
        this.subsections = subsections;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(sectionId);
        dest.writeValue(sectionTitle);
        dest.writeList(subsections);
    }

    public int describeContents() {
        return  0;
    }

}
