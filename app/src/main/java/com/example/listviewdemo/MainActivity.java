package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    Contact contact1, contact2, contact3, contact4, contact5,contact6;
    //2
    List<Contact> contactList;
    AdapterContact adapterContact;
    //3
    RelativeLayout btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Thành's Contact");

        lvContact = findViewById(R.id.lvContact);
        //2
        btnAdd = findViewById(R.id.btnAdd);
        contactList = new ArrayList<>();

        contact1 = new Contact("Boos", "0974499961", false);
        contact2 = new Contact("Mej", "0365217886", true);
        contact3 = new Contact("Về nhà 2", "03796788243", false);
        contact4 = new Contact("Ah Nam", "0975900740", false);
        contact5 = new Contact("Ah Quân", "0979268505", true);
        contact6 = new Contact("PP","0329098112",true);


        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);

        //2
        adapterContact = new AdapterContact(contactList);

        lvContact.setAdapter(adapterContact);

        //3
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getBaseContext(),"ootoke",Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddNewContact.class);
                startActivity(intent);
            }
        });

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = contactList.get(i).getName();
                String number = contactList.get(i).getNumber();
                Toast.makeText(getBaseContext(), "Name: " + name, Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, EditContact.class);
                //
                intent.putExtra("name", name);
                intent.putExtra("phoneNumber", number);
                startActivity(intent);
            }
        });
    }
}
