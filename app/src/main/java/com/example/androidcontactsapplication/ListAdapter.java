package com.example.androidcontactsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ContactList contactList;
    ArrayList<ContactList> mContactList;

    public ListAdapter(Context applicationContext, ArrayList<ContactList> list){
        this.context = context;
        this.mContactList = list;
        inflater = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return mContactList.size();
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
        ContactList item = mContactList.get(i);
        if (item != null) {
            itemText.setText(item.getmName());
        }
        return vi;
    }


}
