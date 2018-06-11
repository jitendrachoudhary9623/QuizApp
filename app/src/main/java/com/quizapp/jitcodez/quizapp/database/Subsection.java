
package com.quizapp.jitcodez.quizapp.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subsection implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("detail")
    @Expose
    private String detail;
    public final static Creator<Subsection> CREATOR = new Creator<Subsection>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Subsection createFromParcel(Parcel in) {
            return new Subsection(in);
        }

        public Subsection[] newArray(int size) {
            return (new Subsection[size]);
        }

    }
    ;

    protected Subsection(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.detail = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Subsection() {
    }

    /**
     * 
     * @param id
     * @param detail
     * @param title
     */
    public Subsection(String title, String id, String detail) {
        super();
        this.title = title;
        this.id = id;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(id);
        dest.writeValue(detail);
    }

    public int describeContents() {
        return  0;
    }

}
