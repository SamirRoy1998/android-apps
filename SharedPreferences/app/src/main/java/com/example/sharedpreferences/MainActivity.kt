package com.example.sharedpreferences

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
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
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        val save: Button = findViewById(R.id.btnSave)
        val load: Button = findViewById(R.id.btnLoad)
        val keyBoard = getSystemService(INPUT_METHOD_SERVICE)as InputMethodManager

        save.setOnClickListener {
            keyBoard.hideSoftInputFromWindow(it.windowToken, 0)
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val country = findViewById<EditText>(R.id.etCountry).text.toString()
            val isAdult = findViewById<CheckBox>(R.id.cbIsAdult).isChecked

            editor.putString("name", name)
            editor.putString("country", country)
            editor.putBoolean("isAdult", isAdult)
            editor.apply()
        }

        load.setOnClickListener {
            keyBoard.hideSoftInputFromWindow(it.windowToken, 0)
            val name = sharedPref.getString("name", "")
            val country = sharedPref.getString("country", "")
            val isAdult = sharedPref.getBoolean("isAdult", false)
            findViewById<TextView>(R.id.tvName).apply {
                text = name
                visibility = View.VISIBLE
            }
            findViewById<TextView>(R.id.tvCountry).apply {
                text = country
                visibility = View.VISIBLE
            }
            findViewById<TextView>(R.id.tvIsAdult).apply {
                text = if (isAdult) "Yes" else "No"
                visibility = if (name==""||country=="")View.GONE else View.VISIBLE
            }
            findViewById<TextView>(R.id.tvNameHeading).visibility =if (name=="") View.GONE else View.VISIBLE
            findViewById<TextView>(R.id.tvCountryHeading).visibility =if (country=="") View.GONE else View.VISIBLE
            findViewById<TextView>(R.id.tvIsAdultHeading).visibility =if (name==""||country=="") View.GONE else View.VISIBLE
        }
    }
}