package com.example.recyclerviewexample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts = new ArrayList<>();
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
        RecyclerView recyclerView=findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.a, "Ram","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.b, "Sham","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.c, "Jodu","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.d, "Modhu","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.e, "Hori","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.f, "Ramen","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.g, "Rakesh","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.h, "Gita","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.i, "Sunita","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.j, "Miya","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.a, "Ram","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.b, "Sham","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.c, "Jodu","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.d, "Modhu","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.e, "Hori","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.f, "Ramen","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.g, "Rakesh","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.h, "Gita","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.i, "Sunita","0123456789"));
        arrContacts.add(new ContactModel(R.drawable.j, "Miya","0123456789"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}