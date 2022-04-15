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

    private static Context context; //declaring
    private ArrayList<Contact> contactList;
    SharedPreferences sharedPreferences;

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

    public void AddContact (Contact contact){ //add contact to sharedpreference
        ArrayList<Contact> contactList; //array list of contacts
        contactList = getContactList(); //getting the contact list and if its null creating a new one
        if (contactList == null){
            contactList = new ArrayList<Contact>();
        }
        contactList.add(contact); //adding the contact to the list
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(contactList); //passing the list to json
        editor.putString("cList", json); //saving the list
        editor.apply();
    }

    public ArrayList<Contact> EditContact (int position, Contact contact) { //passing the position in database and the contact

        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cList", null);
        Type type = new TypeToken<ArrayList<Contact>>(){}.getType();
        contactList = gson.fromJson(json, type); //getting the contat list and saving it as contactlist
        contactList.set(position, contact); //setting the positon and contact after reading it from json

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String jSon = gson.toJson(contactList); //passing back the updated contact list
        editor.putString("cList", jSon); //adding it to data
        editor.apply();

        if (contactList == null){
            contactList = new ArrayList<>();
        }
        return contactList;
    }

    public ArrayList<Contact> DeleteContact (int position) { //getting the positon in shared preference

        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cList", null); //reading the contact list
        Type type = new TypeToken<ArrayList<Contact>>(){}.getType();
        contactList = gson.fromJson(json, type);
        contactList.remove(position); //removing it from the data and saving it back (in the next lines)

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


    public ArrayList<Contact> getContactList(){ //reading the contact list from shared preference

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


