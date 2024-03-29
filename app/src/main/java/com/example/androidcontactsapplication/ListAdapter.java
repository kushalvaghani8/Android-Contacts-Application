package com.example.androidcontactsapplication;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    DataHandler dataHandler;
    Context context;
    LayoutInflater inflater;
    Contact contactList;
    ArrayList<Contact> mContactList;

    public ListAdapter(Context applicationContext){
        this.context = applicationContext;
        dataHandler = DataHandler.getInstance(applicationContext);
        this.mContactList = dataHandler.getContactList();
        inflater = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return dataHandler.getContactList().size();
    } //reading the contact list size to populate data in list

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if(vi == null)
            vi = inflater.inflate(R.layout.list_item,null ); //setting up the list view
        TextView itemText = (TextView) vi.findViewById(R.id.listItemName);
        Contact item = mContactList.get(i);
        if (item != null) {
            itemText.setText(item.getmName()); //populating the listview with names
        }
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(context, EditContact.class); //on click for list view
                intentAdd.putExtra("index", i); //passing the selected contacts index
                intentAdd.putExtra("mName", item.getmName()); //name
                intentAdd.putExtra("mContact", item.getmContact()); //contact
                context.startActivity(intentAdd);

            }
        });
        return vi;
    }


}
