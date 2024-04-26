package com.example.listexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    ArrayList<String> arrNames = new ArrayList<>();

    Spinner spinner;
    ArrayList<String> arrIds = new ArrayList<>();

    AutoCompleteTextView autoCompleteTextView;
    ArrayList<String> arrLanguages = new ArrayList<>();

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

        arrNames.add("Samir");
        arrNames.add("Ram");
        arrNames.add("Rahim");
        arrNames.add("Ranjan");
        arrNames.add("Abhi");
        arrNames.add("Abhijit");
        arrNames.add("Rahul");
        arrNames.add("Rupa");
        arrNames.add("Sonali");
        arrNames.add("Gita");
        arrNames.add("Sunita");
        arrNames.add("Susmita");
        arrNames.add("Mitali");
        arrNames.add("Rawnok");
        arrNames.add("Vikash");
        arrNames.add("Sanjay");
        arrNames.add("Subham");
        arrNames.add("Subhamoy");
        arrNames.add("Riki");
        arrNames.add("Souvik");
        arrNames.add("Prosenjit");
        arrNames.add("Subash");
        arrNames.add("Shipra");

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
        listview.setAdapter(listViewAdapter);
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

        spinner = findViewById(R.id.spinner);

        arrIds.add("Aadhar card");
        arrIds.add("Voter card");
        arrIds.add("Pan card");
        arrIds.add("Driving License");
        arrIds.add("Bank Passbook");

        ArrayAdapter<String> spinnerAdapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdapter);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        arrLanguages.add("Hindi");
        arrLanguages.add("English");
        arrLanguages.add("Bengali");
        arrLanguages.add("Marathi");
        arrLanguages.add("Gujrati");
        arrLanguages.add("Nepali");
        arrLanguages.add("Assamese");
        arrLanguages.add("Boro");
        arrLanguages.add("Manipuri");
        arrLanguages.add("Khasi");
        arrLanguages.add("Mizo");
        arrLanguages.add("Odia");
        arrLanguages.add("Telegu");
        arrLanguages.add("Kannada");
        arrLanguages.add("Punjabi");
        arrLanguages.add("Tamil");
        arrLanguages.add("Kashmiri");
        arrLanguages.add("Malayalam");

        ArrayAdapter<String> acTxtVwAdapter= new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrLanguages);
        autoCompleteTextView.setAdapter(acTxtVwAdapter);
    }
}