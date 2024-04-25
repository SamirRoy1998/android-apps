package com.example.listexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<String> arrName = new ArrayList<>();

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
        listview = findViewById(R.id.listview);

        arrName.add("Samir");
        arrName.add("Ram");
        arrName.add("Rahim");
        arrName.add("Ranjan");
        arrName.add("Abhi");
        arrName.add("Abhijit");
        arrName.add("Rahul");
        arrName.add("Rupa");
        arrName.add("Sonali");
        arrName.add("Gita");
        arrName.add("Sunita");
        arrName.add("Susmita");
        arrName.add("Mitali");
        arrName.add("Rawnok");
        arrName.add("Vikash");
        arrName.add("Sanjay");
        arrName.add("Subham");
        arrName.add("Subhamoy");
        arrName.add("Riki");
        arrName.add("Souvik");
        arrName.add("Prosenjit");
        arrName.add("Subash");
        arrName.add("Shipra");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrName);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              if(position==0){
                  Toast.makeText(MainActivity.this, "I am Samir", Toast.LENGTH_SHORT).show();
              } else if (position==1) {
                  Toast.makeText(MainActivity.this, "I am Ram", Toast.LENGTH_SHORT).show();
              } else if (position==2) {
                  Toast.makeText(MainActivity.this, "I am Rahim", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }
}