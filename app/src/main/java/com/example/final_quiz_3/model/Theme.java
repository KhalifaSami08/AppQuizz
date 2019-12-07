package com.example.final_quiz_3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Theme implements Parcelable{
    private int id;
    private String name;

    public Theme(String name) {
        this.name = name;
    }

    public Theme(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Theme(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Theme> CREATOR = new Parcelable.Creator<Theme>() {
        @Override
        public Theme createFromParcel(Parcel in) {
            return new Theme(in);
        }

        @Override
        public Theme[] newArray(int size) {
            return new Theme[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
