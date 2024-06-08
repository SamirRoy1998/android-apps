package com.example.menubar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miSettings -> Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()
            R.id.miAddContact -> Toast.makeText(this,"Add Contact",Toast.LENGTH_SHORT).show()
            R.id.miFavorites -> Toast.makeText(this,"Favorites",Toast.LENGTH_SHORT).show()
            R.id.miFeedBack -> Toast.makeText(this,"Give FeedBack",Toast.LENGTH_SHORT).show()
            R.id.miCloseApp -> finish()
        }
        return true
    }
}