package com.example.wiki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner mnActSpn;
    ArrayList<String> mnActCategory = new ArrayList<>();
    Button main_btnnext;

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

        mnActSpn=findViewById(R.id.main_spinner);

        mnActCategory.add("Flower");
        mnActCategory.add("Fruits");

        ArrayAdapter<String> mnActSpn_adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,mnActCategory);
        mnActSpn.setAdapter(mnActSpn_adapter);

        main_btnnext=findViewById(R.id.main_btnnext);
        Intent il1, il2;
        il1=new Intent(MainActivity.this,list_1.class);
        il2=new Intent(MainActivity.this,list2.class);



    }
}