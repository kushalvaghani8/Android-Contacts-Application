package com.example.androidcontactsapplication;

public class ContactList {

    private String mName;
    private int mContact;

    public ContactList(String name, int contact) {
        mName = name;
        mContact = contact;
    }

    public String getmName() {
        return mName;
    }

    public int getmContact() {
        return mContact;
    }
}

