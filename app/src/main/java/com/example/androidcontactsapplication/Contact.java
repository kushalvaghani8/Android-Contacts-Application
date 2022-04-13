package com.example.androidcontactsapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Contact implements Serializable {

    private String mName;
    private String mContact;

    public Contact(String name, String contact) {
        mName = name;
        mContact = contact;
    }

    public String getmName() {
        return mName;
    }

    public String getmContact() {
        return mContact;
    }



}

