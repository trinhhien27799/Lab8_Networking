package com.example.lab8_networking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {
    Button btnPickPicture, btnInsertValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        btnInsertValues = findViewById(R.id.insertValue);
        btnPickPicture = findViewById(R.id.uploadImage);

        btnPickPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseActivity.this, B3_Insert_Picture_Activity.class));
            }
        });

        btnInsertValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseActivity.this, ArrayListActivity.class));
            }
        });
    }
}