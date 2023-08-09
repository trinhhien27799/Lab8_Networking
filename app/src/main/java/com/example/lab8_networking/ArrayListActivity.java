package com.example.lab8_networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayListActivity extends AppCompatActivity {
    FirebaseAuth auth;
    String[] demo = new String[]{"demo1", "demo2", "demo3"};
    Button btnInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);

        btnInsert = findViewById(R.id.btnInsert);

        auth = FirebaseAuth.getInstance();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task<Void> database = FirebaseDatabase.getInstance().getReference().child("todo").setValue(Arrays.asList(demo));
            }
        });
    }
}