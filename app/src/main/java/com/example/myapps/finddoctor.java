package com.example.myapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class finddoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctor);

        CardView back = findViewById(R.id.cardback);
        CardView familyfici = findViewById(R.id.cardphyci);
        CardView familydeli = findViewById(R.id.carddita);
        CardView familycardio  = findViewById(R.id.cardcarlo);
        CardView familsergon = findViewById(R.id.cardsergen);
        CardView familydentist = findViewById(R.id.carddentist);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Profile.class);
                startActivity(intent);
            }
        });

        familyfici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DoctorDetails.class);

                intent.putExtra("Title","Family Physician");
                startActivity(intent);

            }
        });


        familydeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DoctorDetails.class);

                intent.putExtra("Title","dietician");
                startActivity(intent);

            }
        });


        familycardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DoctorDetails.class);

                intent.putExtra("Title","cardiologist");
                startActivity(intent);

            }
        });


        familsergon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DoctorDetails.class);

                intent.putExtra("Title","Sergen");
                startActivity(intent);

            }
        });

        familydentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DoctorDetails.class);

                intent.putExtra("Title","Dentist");
                startActivity(intent);

            }
        });


    }
}