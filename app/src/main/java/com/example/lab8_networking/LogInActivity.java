package com.example.lab8_networking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
    EditText inEmail, inPass;
    Button loginBtn;
    FirebaseAuth firebaseAuth;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        inEmail = findViewById(R.id.inEmail_Login);
        inPass = findViewById(R.id.inPassword_Login);
        loginBtn = findViewById(R.id.btnLogin);
        txtResult = findViewById(R.id.textResult_Login);
        firebaseAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inEmail.getText().toString();
                String pass = inPass.getText().toString();

                // Chức năng đăng nhập của firebase
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LogInActivity.this, ChooseActivity.class));
                        }
                    }
                });
            }
        });
    }
}