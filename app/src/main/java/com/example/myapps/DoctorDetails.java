package com.example.myapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorDetails extends AppCompatActivity {
    Button button ,btn;
    private final String CHANNEL_ID = "Inbox Style Notification";
    private final int NOTIFICATION_ID = 1;


    /*
    String [][] Doctor_Details ={};
    TextView tv;
    Button btn;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    String[][] doctor_material1 =
            {

            {"Doctor name: Riaz Ahmed", "Hospital address: CMC", "Mobile number: 017345876251 ","fees: 500"},
                {"Doctor name: Salma Akter", "Hospital address: MA-O_Shishu", "Mobile number: 018937652871 ","fees: 600"},
                {"Doctor name: saiful islam", "Hospital address: Park view", "Mobile number: 01916738920748 ","fees: 400"},
                    {"Doctor name: fahim khan", "Hospital address: CMC", "Mobile number: 017739163893 ","fees: 600"},
                    {"Doctor name: AJM tarek", "Hospital address: Mattropoliton", "Mobile number: 015027849314 ","fees: 300"}


     };
    String[][] doctor_material2 =
            {

                    {"Doctor name: Riaz Ahmed", "Hospital address: CMC", "Mobile number: 017345876251 ","fees: 500"},
                    {"Doctor name: Salma Akter", "Hospital address: MA-O_Shishu", "Mobile number: 018937652871 ","fees: 600"},
                    {"Doctor name: saiful islam", "Hospital address: Park view", "Mobile number: 01916738920748 ","fees: 400"},
                    {"Doctor name: fahim khan", "Hospital address: CMC", "Mobile number: 017739163893 ","fees: 600"},
                    {"Doctor name: AJM tarek", "Hospital address: Mattropoliton", "Mobile number: 015027849314 ","fees: 300"}


            };
    String[][] doctor_material3 =
            {

                    {"Doctor name: Riaz Ahmed", "Hospital address: CMC", "Mobile number: 017345876251 ","fees: 500"},
                    {"Doctor name: Salma Akter", "Hospital address: MA-O_Shishu", "Mobile number: 018937652871 ","fees: 600"},
                    {"Doctor name: saiful islam", "Hospital address: Park view", "Mobile number: 01916738920748 ","fees: 400"},
                    {"Doctor name: fahim khan", "Hospital address: CMC", "Mobile number: 017739163893 ","fees: 600"},
                    {"Doctor name: AJM tarek", "Hospital address: Mattropoliton", "Mobile number: 015027849314 ","fees: 300"}


            };
    String[][] doctor_material4 =
            {

                    {"Doctor name: Riaz Ahmed", "Hospital address: CMC", "Mobile number: 017345876251 ",  "fees: 500"},
                    {"Doctor name: Salma Akter", "Hospital address: MA-O_Shishu", "Mobile number: 018937652871 ","fees: 600"},
                    {"Doctor name: saiful islam", "Hospital address: Park view", "Mobile number: 01916738920748 ","fees: 400"},
                    {"Doctor name: fahim khan", "Hospital address: CMC", "Mobile number: 017739163893 ","fees: 600"},
                    {"Doctor name: AJM tarek", "Hospital address: Mattropoliton", "Mobile number: 015027849314 ","fees: 300"}


            };
    String[][] doctor_material5 =
            {

                    {"Doctor name: Riaz Ahmed", "Hospital address: CMC", "Mobile number: 017345876251 ","fees: 500"},
                    {"Doctor name: Salma Akter", "Hospital address: MA-O_Shishu", "Mobile number: 018937652871 ","fees: 600"},
                    {"Doctor name: saiful islam", "Hospital address: Park view", "Mobile number: 01916738920748 ","fees: 400"},
                    {"Doctor name: fahim khan", "Hospital address: CMC", "Mobile number: 017739163893 ","fees: 600"},
                    {"Doctor name: AJM tarek", "Hospital address: Mattropoliton", "Mobile number: 015027849314 ","fees: 300"}


            };

*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        btn =findViewById(R.id.token4);



/*
        tv=findViewById(R.id.dcdetails);
        btn =findViewById(R.id.buttonb);
        Intent intent = getIntent();
        String Title = intent.getStringExtra("Title");
        tv.setText(Title);

        if(Title.compareTo("Family Physician")==0)
            Doctor_Details= doctor_material1;
        else
        if(Title.compareTo("Dietitian")==0)
            Doctor_Details= doctor_material2;
        else
        if(Title.compareTo("Dentist")==0)
            Doctor_Details= doctor_material3;
        else
        if(Title.compareTo("Sergen ")==0)
            Doctor_Details= doctor_material4;
        else

            Doctor_Details= doctor_material5;




            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),finddoctor.class);
                startActivity(intent);
            }
        });

            list=new ArrayList<>();
            for ( int i=0;i<Doctor_Details.length;i++){
              item = new HashMap<String,String>();
              item.put("line1",Doctor_Details[1][0]);
                item.put("line2",Doctor_Details[1][1]);
                item.put("line3",Doctor_Details[1][2]);
                item.put("line4",Doctor_Details[1][3]);
                item.put("line5","fees"+Doctor_Details[1][4]+"/=");
                list.add(item);

            }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView lst = findViewById(R.id.list);
        lst.setAdapter(sa);

        */



/*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotification();
                addNotification();

            }
        });

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

 */



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Token.class);

                startActivity(intent);

            }
        });



    }



    }



