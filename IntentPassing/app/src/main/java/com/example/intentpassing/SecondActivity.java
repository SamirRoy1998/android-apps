package com.example.intentpassing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent fromMnAct = getIntent();                               //8th assign this activity Intent variable from the main activity
        String Name = fromMnAct.getStringExtra("Name");         //9th Store data by putting key to a variable
        int Age = fromMnAct.getIntExtra("Age",0);

        TextView details;                                             // making a variable where we show the data
        details = findViewById(R.id.details);                         // assign that variable to xml id
        details.setText("Name: "+Name+ "\nAge: " + Age);              // now set those data which we pull from the main activity
    }
}