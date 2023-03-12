package com.example.myapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class signIn extends AppCompatActivity implements  View.OnClickListener {
    EditText suser, spass;
    Button sbtn;
    TextView stv;
    FirebaseAuth nAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        nAuth=FirebaseAuth.getInstance();

        suser = findViewById(R.id.signname);
        spass = findViewById(R.id.signpassword);
        sbtn = findViewById(R.id.signloginbtn);

        sbtn.setOnClickListener(this);


    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signloginbtn:
                userRegister();
                break;
            case R.id.user:
                Intent intent = new Intent(getApplicationContext(),signIn.class);
                startActivity(intent);
                break;

        }
    }

    private void userRegister() {

        String email = suser.getText().toString().trim();
        String password= spass.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty())
        {
            suser.setError("Enter an email address");
            spass.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            suser.setError("Enter a valid email address");
            spass.requestFocus();
            return;
        }

        //checking the validity of the password
        if(email.isEmpty())
        {
            suser.setError("Enter a password");
            spass.requestFocus();
            return;
        }

        nAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(getApplicationContext(), "Register is Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    // If sign in fails, display a message to the user.
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(), "Register already Successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }


}