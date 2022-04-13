package com.example.androidcontactsapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class noUseContact implements Parcelable {

    private String mName;
    private int mContact;

    public noUseContact(String name, int contact) {
        mName = name;
        mContact = contact;
    }

    public String getmName() {
        return mName;
    }

    public int getmContact() {
        return mContact;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeInt(mContact);
    }

    public static final Parcelable.Creator<DataHandler> CREATOR = new Parcelable.Creator<DataHandler>() {
        public DataHandler createFromParcel(Parcel in) {
            return new DataHandler(in);
        }
        public DataHandler[] newArray(int size) {
            return new DataHandler[size];
        }
    };

    // used by the creator above
    private noUseContact(Parcel in) {
        mName = in.readString();
        mContact = in.readInt();

    }

}

