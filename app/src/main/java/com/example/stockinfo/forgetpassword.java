package com.example.stockinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {
    EditText gmail;
    Button resetpass;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        gmail = findViewById(R.id.resetmail);
        resetpass=findViewById(R.id.resetpassbut);
        fAuth = FirebaseAuth.getInstance();
        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = gmail.getText().toString().trim();
                System.out.println(fAuth);
                fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(forgetpassword.this,"Reset Link Sent !Kindly Check Your Mail",Toast.LENGTH_SHORT);
                        startActivity(new Intent(getApplicationContext(),Login.class));
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        });

    }
    public void onClickLogin (View v)
    {
        Intent i = new Intent(forgetpassword.this, Login.class);
        startActivity(i);
    }
}