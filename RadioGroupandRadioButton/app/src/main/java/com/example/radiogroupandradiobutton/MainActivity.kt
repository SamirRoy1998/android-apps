package com.example.radiogroupandradiobutton

import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.radiogroupandradiobutton.databinding.ActivityMainBinding

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

        b.btnDone.setOnClickListener {
            try {
                val number = b.rgNumber.checkedRadioButtonId
                val checkedNumber = findViewById<RadioButton>(number).text.toString()

                val color = b.rgColor.checkedRadioButtonId
                val checkedColor = findViewById<RadioButton>(color).text.toString()

                var result = arrayOf(checkedColor,checkedNumber).joinToString(", ")

                b.txtResult.text = result
            } catch (e: Exception) {
            }
        }
    }
}