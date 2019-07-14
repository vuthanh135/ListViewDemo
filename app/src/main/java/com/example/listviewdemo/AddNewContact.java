package com.example.listviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewContact extends AppCompatActivity {

    Spinner spinner;
    //btn
    Button btnGroup;
    Button btnTune;
    Button btnSend;
    //String[] phoneType = {"Home", "Facebook", "Ban be"}
    ArrayList<String> phoneType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        spinner = findViewById(R.id.spPhoneStyleContact);
        phoneType = new ArrayList<>();
        phoneType.add("Home");
        phoneType.add("Facebook");
        phoneType.add("Bạn bè");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, phoneType);

        spinner.setAdapter(arrayAdapter);

        //btn
        btnGroup = findViewById(R.id.btnGroup);
        btnTune = findViewById(R.id.btnTune);
        btnSend = findViewById(R.id.btnSend);

        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String[] tunes = {"Anh Anh Anhh","EM EM EM","Về nah đi con"};
                AlertDialog dialog = new AlertDialog.Builder(AddNewContact.this)
                        //
                        //.setTitle("Messenger")
                        //.setMessage("click Ok")
                        .setTitle("Set Ringtunes")
                        .setSingleChoiceItems(tunes, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(getBaseContext(),"Da chon"+i,Toast.LENGTH_LONG).show();
                            }
                        })
                        //
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"Đã chon"+i,Toast.LENGTH_LONG).show();
                            }
                        })
                        //
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"Cancel", Toast.LENGTH_LONG).show();
                            }
                        })
                        .create();


                dialog.show();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),view);
                popupMenu.getMenuInflater().inflate(R.menu.menucontact,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.mnSaveContact:
                                Toast.makeText(getBaseContext(),"Save",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.mnCancelContact:
                                Toast.makeText(getBaseContext(),"Cancle",Toast.LENGTH_LONG).show();
                                break;
                        }

                        return false;
                    }

                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menucontact, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnSaveContact:
                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_LONG).show();
            case R.id.mnCancelContact:
                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_LONG).show();
            case R.id.mnOkContact:
                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
