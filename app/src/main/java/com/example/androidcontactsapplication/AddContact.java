package com.example.androidcontactsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    EditText mName, mContactNumber; //declaring
    Button mSaveButton;
    DataHandler DataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_contact); //initiating
        DataHandler = DataHandler.getInstance(getApplicationContext()); //getting the application context
        mName = findViewById(R.id.eTName); //initiating
        mContactNumber = findViewById(R.id.eTContactNumber);
        mSaveButton = findViewById(R.id.saveButton);



        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            } //calling the save method on button click
        });
    }

    //
    private void saveData(){
        String name = mName.getText().toString(); //getting the text from text fields
        String number = mContactNumber.getText().toString();
        Contact newItem = new Contact(name, number); //constructor for contact class and passing the value
        DataHandler.AddContact(newItem); //passing the data to datahandler class to save it to shared prefrence


        Toast.makeText(AddContact.this, "Contact Saved", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddContact.this, MainActivity.class);
        startActivity(intent);
        finish();
    }




    /*_________________________________________

             Add Delete item menu here
    ____________________________________________*/



}