package com.example.androidcontactsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    EditText mName, mContactNumber;
    Button mSaveButton;
    SharedPreferences sharedPreferences;
    ArrayList<ContactList> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        mName = findViewById(R.id.eTName);
        mContactNumber = findViewById(R.id.eTContactNumber);
        mSaveButton = findViewById(R.id.saveButton);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);


        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    //
    private void saveData(){
        String name = mName.getText().toString();
        int number = Integer.parseInt(mContactNumber.getText().toString());

        ContactList newItem = new ContactList(name, number);

        contactList.add(newItem);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(contactList);
        editor.putString("cList", json);
        editor.apply();

        Toast.makeText(AddContact.this, "Contact Saved", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddContact.this, MainActivity.class);
        startActivity(intent);
        finish();
    }




    /*_________________________________________

             Add Delete item menu here
    ____________________________________________*/



}