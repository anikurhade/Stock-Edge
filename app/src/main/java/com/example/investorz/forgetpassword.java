package com.example.investorz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {
    //EditText npassword,cnfpassword,
    EditText emailtxt;
    Button resetpass;
    ProgressBar pb;
    String email;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        emailtxt=findViewById(R.id.email);

        resetpass=findViewById(R.id.resetpassbut);
        pb=findViewById(R.id.pbforgetpass);
        fAuth=FirebaseAuth.getInstance();

        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        validatedata();

            }
        });
    }
    private  void  validatedata()
    {
         email=emailtxt.getText().toString().trim();
        if (email.isEmpty())
        {
            emailtxt.setError("Email Required");

        }
        else
        {
             forgetpassword(email);
        }


    }
    private  void forgetpassword(String email)
    {

        fAuth.sendPasswordResetEmail(email)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
               Toast.makeText(forgetpassword.this,"Password Reset Email Send To Your Mail Kindly CHeck And Reset It",Toast.LENGTH_SHORT);
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(forgetpassword.this,"Opps Error Occured Error :"+e,Toast.LENGTH_SHORT);
                startActivity(new Intent(getApplicationContext(),Login.class));

            }
        });
    }

    public void onClickLogin (View v)
    {
        Intent i = new Intent(forgetpassword.this, Login.class);
        startActivity(i);
    }
}