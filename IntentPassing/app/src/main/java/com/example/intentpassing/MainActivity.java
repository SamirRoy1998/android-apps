package com.example.intentpassing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnNext;                                                             //1st create Button variable
        btnNext = findViewById(R.id.btnNext);                                       //2nd Button variable link to xml btn id

        Intent iNext;                                                               //3rd make Intent variable to perform activity
        iNext=new Intent(MainActivity.this, SecondActivity.class);    //4th write instruct for intent's variable what to do
        btnNext.setOnClickListener(new View.OnClickListener() {                     //5th set button on click listener
            @Override
            public void onClick(View v) {
                startActivity(iNext);                                               //6th and last start activity set for intent's variable
            }
        });
    }
}