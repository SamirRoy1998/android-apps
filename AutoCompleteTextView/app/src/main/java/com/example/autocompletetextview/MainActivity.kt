package com.example.autocompletetextview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.autocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_main)
        b.mainLayout = this
        ViewCompat.setOnApplyWindowInsetsListener(b.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val language =
            arrayOf(
                "English Language",
                "Bengali Language",
                "Assamese Language",
                "Bodo Language",
                "Nepali Language",
                "Marathi Language",
                "Gujarati Language",
                "Hindi Language",
                "Kannada Language",
                "Kashmiri Language",
                "Konkani Language",
                "Malayalam Language",
                "Manipuri Language",
                "Oriya Language",
                "Punjabi Language",
                "Sanskrit Language",
                "Sindhi Language",
                "Tamil Language",
                "Telugu Language",
                "Urdu Language",
                "French Language",
                "German Language",
                "Spanish Language",
                "Italian Language",
                "Portuguese Language",
                "Russian Language",
                "Chinese Language",
                "Japanese Language",
                "Korean Language",
                "Vietnamese Language",
                "Thai Language",
                "Swahili Language",
                "Arabic Language",
                "Turkish Language",
                "Persian Language",
                "Greek Language",
                "Dutch Language",
                "Hungarian Language",
                "Polish Language",
                "Romanian Language",
                "Czech Language",
                "Slovak Language",
                "Bulgarian Language",
                "Serbian Language",
                "Croatian Language",
                "Ukrainian Language",
                "Hebrew Language",
                "Finnish Language",
                "Norwegian Language",
                "Swedish Language"
            )
        val customAdapter = ArrayAdapter(
            this,
            com.google.android.material.R.layout.m3_auto_complete_simple_item,
            language
        )
        b.actvSearch.setAdapter(customAdapter)
        b.actvSearch.threshold = 4
    }
}