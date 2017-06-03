package com.mahmoud_ashraf.firebase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // before read/write you need to get instance from the Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // add key
        DatabaseReference myName = database.getReference("my_name");
        //add value
        myName.setValue("mahmouddd");

    }
}
