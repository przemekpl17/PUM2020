package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class ListaCwiczen implements Parcelable {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ListaCwiczen(int imageResource, String text1, String text2) {
        this.mImageResource = imageResource;
        this.mText1 = text1;
        this.mText2 = text2;
    }

    protected ListaCwiczen(Parcel in) {
        mImageResource = in.readInt();
        mText1 = in.readString();
        mText2 = in.readString();
    }

    public static final Creator<ListaCwiczen> CREATOR = new Creator<ListaCwiczen>() {
        @Override
        public ListaCwiczen createFromParcel(Parcel in) {
            return new ListaCwiczen(in);
        }

        @Override
        public ListaCwiczen[] newArray(int size) {
            return new ListaCwiczen[size];
        }
    };

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mText1);
        dest.writeString(mText2);
    }
}
