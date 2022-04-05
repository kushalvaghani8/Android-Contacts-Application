package com.example.androidcontactsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    ArrayList<ContactList> mContactList;
    SharedPreferences sharedPreferences;
    ListAdapter mListAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();

        mListView = (ListView) findViewById(R.id.listView);
        mListAdapter = new ListAdapter(this, mContactList);
        mListView.setAdapter(mListAdapter);
    }

    /*_________________________________________

                Creating the Menu Item
    ____________________________________________*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;


    }

      /*_________________________________________

                Adding the Menu Item
      ____________________________________________*/


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intentAdd = new Intent(this, AddContact.class);
                startActivity(intentAdd);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void loadData(){
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("cList", null);
        Type type = new TypeToken<ArrayList<ContactList>>(){}.getType();
        mContactList = gson.fromJson(json, type);

        if (mContactList == null){
            mContactList = new ArrayList<>();
        }


       // editor.putString("cList", json);
    }



}