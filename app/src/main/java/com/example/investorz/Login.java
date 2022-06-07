package com.example.investorz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText gmail, password;
    TextView forgetpassword;
    Button logn;

    ProgressBar pblogn;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        gmail = findViewById(R.id.mail);
        password = findViewById(R.id.passwordlgn);
        logn = findViewById(R.id.lgn);
        forgetpassword=findViewById(R.id.forgetpass);
        fAuth = FirebaseAuth.getInstance();
        pblogn = findViewById(R.id.pblgn);

    logn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = gmail.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                gmail.setError("Email is Required.");
                return;
            }

            if (TextUtils.isEmpty(pass)) {
                password.setError("Password is Required.");
                return;
            }

            if (password.length() < 8) {
                password.setError("Password Must be >= 8 Characters");
                return;
            }

            pblogn.setVisibility(View.VISIBLE);
            //------------------
            //---------Auth The User
            fAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Login.this, "Logged In .", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                    }
                    else {
                        Toast.makeText(Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        pblogn.setVisibility(View.INVISIBLE);

                    }
                }
            });
        }
    });
forgetpassword.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), forgetpassword.class));
    }
});

    }


    public void onClickRegirecttoregister (View v)
    {
        Intent i = new Intent(Login.this, Register.class);
        startActivity(i);
    }
}

