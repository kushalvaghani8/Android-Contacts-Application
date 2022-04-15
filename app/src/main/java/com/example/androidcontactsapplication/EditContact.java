package com.example.androidcontactsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EditContact extends AppCompatActivity {

    EditText mName, mContactNumber;
    Button mUpdateButton;
    DataHandler DataHandler;
    ArrayList<Contact> contactList;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

       index = getIntent().getIntExtra("index", 0); //getting the index(of selected contact) which was passed from previous intent
        getIntent().getStringExtra("mName"); //getting the name which was passed from previous intent
        getIntent().getStringExtra("mContact");

        DataHandler = DataHandler.getInstance(getApplicationContext()); //getting the application context

        mName = findViewById(R.id.eTName);
        mContactNumber = findViewById(R.id.eTContactNumber);
        mUpdateButton = findViewById(R.id.saveButton);

        mName.setText(getIntent().getStringExtra("mName")); //setting the text in text field from the passed data
        mContactNumber.setText(""+ getIntent().getStringExtra("mContact"));

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditContact();
            }
        });
    }

    private void EditContact(){
        String name = mName.getText().toString();
        String number = mContactNumber.getText().toString();
        Contact newItem = new Contact(name, number);
        DataHandler.EditContact(index, newItem); //passing the data to datahandler class to save it back after update


        Toast.makeText(EditContact.this, "Update Successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditContact.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    /*_________________________________________

              Creating the Menu Item
  ____________________________________________*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_menu, menu);
        return true;
    }

      /*_________________________________________

         Adding the Menu Items Edit and delete
      ____________________________________________*/


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_edit:

                mName.setEnabled(true); //enabling the fields when user selects update
                mContactNumber.setEnabled(true);
                mUpdateButton.setVisibility(View.VISIBLE); // showing the update button

                return true;
            case R.id.menu_delete:
                DataHandler.DeleteContact(index); //if delete item is selected (passing the index to datahandler to delete )
                Toast.makeText(EditContact.this, "Deleted Successful", Toast.LENGTH_SHORT).show(); // if successful shwoing message
                Intent intent = new Intent(EditContact.this, MainActivity.class); //going back to main
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}