package com.example.myapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class Token extends AppCompatActivity {
    Button button ;
    private final String CHANNEL_ID = "Inbox Style Notification";
    private final int NOTIFICATION_ID = 1;
    AutoCompleteTextView act;
    EditText phone , name, date;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    DatabaseReference databaseReference;


    String[] language ={"Dr. Sharmin Srireen",
            "Dr. Salma Akter parvin",
            "Dr. Ariful Islam",
            "Dr. Niaz Morshed kobir",
            "Dr. Aireen Kabir mim  ",
            "Dr. Shuvroto Barua ",
            "Dr. A.J.M Tarekul  ",
            "Dr. Rubayed Ahmed ",
             "Dr. Khan Mahmood  ",
            "Dr. Rakibul Chowdhury ",
            };




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

        databaseReference = FirebaseDatabase.getInstance().getReference("Store");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv =  (AutoCompleteTextView)findViewById(R.id.auto);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);


        button = (Button) findViewById(R.id.token1);
        name=findViewById(R.id.pname);
        act=findViewById(R.id.auto);
        phone=findViewById(R.id.phone);


        date =findViewById(R.id.datepick);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(calendar.YEAR);
                int month = calendar.get(calendar.MONTH);
                int day = calendar.get(calendar.DAY_OF_MONTH);

                datePickerDialog =new DatePickerDialog(getApplicationContext(),onDateSetListener,year,month,day);
                datePickerDialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                date.setText(dayOfMonth+"/"+month+"/"+year);
            }
        };




        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                createNotification();
                addNotification();
                savedata();

            }
        });

    }

    public  void savedata(){
        String pataname= name.getText().toString().trim();
        String paphone = phone.getText().toString().trim();
        String autoc = act.getText().toString().trim();

        String key =databaseReference.push().getKey();
        Store store = new Store (pataname,paphone,autoc);
        databaseReference.child(key).setValue(store);


    }


    private void createNotification() {

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            CharSequence name="Inbox Style Notification";
            String desc="This is all about Inbox Style Notification.";

            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(desc);

            NotificationManager notificationManager=(NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }

    }

    @SuppressLint("MissingPermission")
    private void addNotification() {

        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setSmallIcon(R.drawable.baseline_notifications_active_24);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.baseline_notifications_active_24));
        builder.setContentTitle("Bd Health care Announcement");
        builder.setStyle(new NotificationCompat.InboxStyle()
                .addLine("Hello Dear patient!")
                .addLine("Your appointment is successfully ")
                .addLine("Thank you."));


        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());




    }
}