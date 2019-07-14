package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterContact extends BaseAdapter {//adapter de bieu thi 1 contact

    List<Contact> contactList;


    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //ket noi voi file layout
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.iteamcontact, viewGroup , false);

        TextView tvName = ((View) v).findViewById(R.id.tvName);
        TextView tvNumber = ((View) v).findViewById(R.id.tvNumber);

        Contact contact = contactList.get(i);

        tvName.setText(contact.getName());
        tvNumber.setText(String.valueOf(contact.getNumber()));

        return v;

    }
}
