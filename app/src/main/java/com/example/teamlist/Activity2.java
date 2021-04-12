package com.example.teamlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView text = findViewById(R.id.nameTextView);

        String nama = "Username are not set";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            nama = extras.getString("nama");
        }

    }
}