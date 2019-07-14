package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EditContact extends AppCompatActivity {

    ImageView imEdit;
    TextView tvEditName;
    TextView tvEditPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        imEdit = findViewById(R.id.imEdit);
        tvEditName = findViewById(R.id.tvEditName);
        tvEditPhoneNumber = findViewById(R.id.tvEditPhoneNumber);

        Intent intent = getIntent();

        String editName = intent.getStringExtra("name");
        String editPhoneNumber = intent.getStringExtra("phoneNumber");

        tvEditName.setText(editName);
        tvEditPhoneNumber.setText(editPhoneNumber);
    }
}
