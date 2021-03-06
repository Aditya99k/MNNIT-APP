package com.example.mnnitcentral;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    Button b1,login,forget;
    private DatabaseReference ref;
    EditText user,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);



        login=findViewById(R.id.login);
        forget=findViewById(R.id.forget);
        user=findViewById(R.id.editText);
        pass=findViewById(R.id.editText2);

        b1=findViewById(R.id.signup);
        ref = FirebaseDatabase.getInstance().getReference("users");




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=user.getText().toString().trim();
                final String passwd = pass.getText().toString().trim();
                Query check =ref.orderByChild("email").equalTo(email);

                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists()){
                            String storedpasswd = (dataSnapshot.child(email).child("passwd").getValue(String.class));
                            String name = (dataSnapshot.child(email).child("fullname").getValue(String.class));
                            if (storedpasswd.equals(passwd)){
                                Toast.makeText(login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(login.this,nextactivity.class);
                                intent.putExtra("name",name);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(login.this, "Wrong Password entered.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        else {
                            Toast.makeText(login.this, "User don't exists !   Register Please ...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(login.this,signup.class);
                startActivity(i);
                recreate();

            }
        });

    }
}
