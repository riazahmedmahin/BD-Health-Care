package com.example.myapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {


    EditText eduser, edpass;
    Button btn;
    TextView tv;
    FirebaseAuth nAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nAuth=FirebaseAuth.getInstance();

        eduser = findViewById(R.id.name);
        edpass = findViewById(R.id.password);
        btn = findViewById(R.id.loginbtn);
        tv = findViewById(R.id.user);

        btn.setOnClickListener(this);
        tv.setOnClickListener(this);

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Login in successfully", Toast.LENGTH_SHORT).show();
            }
        });

        */

    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginbtn:
                loginReginter();
                break;
            case R.id.user:
                Intent intent = new Intent(getApplicationContext(),signIn.class);
                startActivity(intent);
                break;

        }
    }

    private void loginReginter() {

        String email = eduser.getText().toString().trim();
        String password = edpass.getText().toString().trim();

        //checking the validity of the email
        if(email.isEmpty())
        {
            eduser.setError("Enter an email address");
            edpass.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            eduser.setError("Enter a valid email address");
            edpass.requestFocus();
            return;
        }

        //checking the validity of the password
        if(email.isEmpty())
        {
            eduser.setError("Enter a password");
            edpass.requestFocus();
            return;
        }

        nAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(),Profile.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login In Unsucessfull", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

