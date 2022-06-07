package com.example.investorz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class userprofile extends AppCompatActivity {
    TextView name,phone,email;
    FirebaseAuth fAuth;
    FirebaseFirestore fstore;
    String Userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

         name=findViewById(R.id.disname);
         phone=findViewById(R.id.disphone);
         email=findViewById(R.id.disemail);

         fAuth=FirebaseAuth.getInstance();
         fstore=FirebaseFirestore.getInstance();
         Userid=fAuth.getCurrentUser().getUid();

        DocumentReference df=fstore.collection("users").document(Userid);
        df.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                phone.setText(value.getString("phone"));
                name.setText(value.getString("fName"));
                email.setText(value.getString("email"));

            }
        });
    }
    public void GotoDashboard(View V)
    {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
    }
    public void Logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
    public void Update(View V)
    {

    }
}