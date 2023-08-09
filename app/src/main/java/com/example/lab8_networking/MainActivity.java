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

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button registerBtn;
    EditText inEmail, inPassword;
    TextView txtResult, btnSwitchLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        registerBtn = findViewById(R.id.btnRegister);
        inEmail = findViewById(R.id.inEmail);
        inPassword = findViewById(R.id.inPassword);
        txtResult = findViewById(R.id.textResult);
        btnSwitchLogin = findViewById(R.id.btnSwitchLogin);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inEmail.getText().toString();
                String pass = inPassword.getText().toString();

                // Chức năng thêm dữ liệu đăng kí vào firebase
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                            txtResult.setText("Bạn Đã Đăng Kí Thành Công");
                        }
                    }
                });
            }
        });

        btnSwitchLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LogInActivity.class));
            }
        });
    }
}