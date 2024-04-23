package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        EditText editWeight, editHeightFt,editHeightInch;
        Button btnCalculate;
        TextView txt_result;

        editWeight = findViewById(R.id.editWeight);
        editHeightFt = findViewById(R.id.editHeightFt);
        editHeightInch = findViewById(R.id.editHeightInch);
        btnCalculate = findViewById(R.id.btnCalculate);
        txt_result = findViewById(R.id.txt_result);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int weight = Integer.parseInt(editWeight.getText().toString());
               int feet = Integer.parseInt(editHeightFt.getText().toString());
               int inch = Integer.parseInt(editHeightInch.getText().toString());

               int totalIn = feet * 12 + inch;
               double totalCm = totalIn * 2.53;
               double totalMtr = totalCm / 100;
               double bmi = weight / (totalMtr * totalMtr);

               if (bmi>25){
                   txt_result.setText("You're Overweight");
               }
               else if (bmi<18){
                   txt_result.setText("You're Underweight");
               }
               else {
                   txt_result.setText("You're Healthy");
               }
            }
        });
    }
}