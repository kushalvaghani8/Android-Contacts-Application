package com.example.androidcontactsapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.preference.PreferenceManager;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

// Contact contact;

public class DataHandler {

    private static Context context;
    private ArrayList<Contact> contactList;
    SharedPreferences sharedPreferences;
    //Contact contact;
    //AddContact addContact;

    private static final DataHandler ourInstance = new DataHandler();

    static SharedPreferences prefs;

    public DataHandler(Parcel in) {

    }

    public DataHandler() {

    }


    public static DataHandler getInstance(Context contextIn) {
        context = contextIn;
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return ourInstance;
    }

    public void AddContact (Contact contact){

        ArrayList<Contact> contactList;
        contactList = getContactList();
        if (contactList == null){
            contactList = new ArrayList<Contact>();
        }
        contactList.add(contact);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(contactList);
        editor.putString("cList", json);
        editor.apply();

    }

    public ArrayList<Contact> EditContact (int position, Contact contact) {

        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cList", null);
        Type type = new TypeToken<ArrayList<Contact>>(){}.getType();
        contactList = gson.fromJson(json, type);
        contactList.set(position, contact);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String jSon = gson.toJson(contactList);
        editor.putString("cList", jSon);
        editor.apply();

        if (contactList == null){
            contactList = new ArrayList<>();
        }
        return contactList;
    }

    public ArrayList<Contact> DeleteContact (int position) {

        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cList", null);
        Type type = new TypeToken<ArrayList<Contact>>(){}.getType();
        contactList = gson.fromJson(json, type);
        contactList.remove(position);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String jSon = gson.toJson(contactList);
        editor.putString("cList", jSon);
        editor.apply();

        if (contactList == null){
            contactList = new ArrayList<>();
        }
        return contactList;
    }




    public SharedPreferences getPreferences(){
        return prefs;
    }


    public ArrayList<Contact> getContactList(){

        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cList", null);
        Type type = new TypeToken<ArrayList<Contact>>(){}.getType();
        contactList = gson.fromJson(json, type);

        if (contactList == null){
            contactList = new ArrayList<>();
        }
       return contactList;
    }
}


