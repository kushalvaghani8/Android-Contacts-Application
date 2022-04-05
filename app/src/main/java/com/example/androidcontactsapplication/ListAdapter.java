package com.example.androidcontactsapplication;

import android.content.Context;
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
        this.context = context;
        dataHandler = DataHandler.getInstance(applicationContext);
        this.mContactList = dataHandler.getContactList();
        inflater = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return dataHandler.getContactList().size();
    }

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
            vi = inflater.inflate(R.layout.list_item,null );

        TextView itemText = (TextView) vi.findViewById(R.id.listItemName);
        Contact item = mContactList.get(i);
        if (item != null) {
            itemText.setText(item.getmName());
        }
        return vi;
    }


}
