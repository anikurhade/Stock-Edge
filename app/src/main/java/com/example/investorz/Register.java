package com.example.investorz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "tag";
    EditText name,password,cpassword,phone,gmail;
    Button reg;
    FirebaseAuth fAuth;
    ProgressBar pb;
    String userID;
    FirebaseFirestore fStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.passwordconf);
        phone=findViewById(R.id.phonenum);
        gmail=findViewById(R.id.email);
        reg=findViewById(R.id.lgn);
        pb=findViewById(R.id.progressBar);
        fAuth=FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Dashboard.class));
            finish();
        }

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = gmail.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String cpass = cpassword.getText().toString().trim();
                final String fullName = name.getText().toString();
                final String phonenum    = phone.getText().toString();
                if(TextUtils .isEmpty(email)){
                    gmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(pass)){
                    password.setError("Password is Required.");
                    return;
                }
                if (!pass.equals(cpass))
                {
                    cpassword.setError("Password Doesnot Match Above Password");
                    return;
                }
                if(password.length() < 8){
                    password.setError("Password Must be >= 8 Characters");
                    return;
                }

                pb.setVisibility(View.VISIBLE);

                //--------------------------------------------
                // Registering The User To Firebase
                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            userID= fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",fullName);
                            user.put("email",email);
                            user.put("phone",phonenum);
                            user.put("password",pass);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "onSuccess: user Profile is created for "+ userID);
                                }
                            });

                            startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                }
        });



    }

    public void onClickRegirecttosignup(View view)
    {
        Intent i = new Intent(Register.this,Login.class);
        startActivity(i);
    }
}