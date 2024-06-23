package com.example.sharedpreferences

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        val keyBoard = getSystemService(INPUT_METHOD_SERVICE)as InputMethodManager

        binding.btnSave.setOnClickListener {
            keyBoard.hideSoftInputFromWindow(it.windowToken, 0)
            val name = binding.etName.text.toString()
            val country = binding.etCountry.text.toString()
            val isAdult = binding.cbIsAdult.isChecked

            editor.putString("name", name)
            editor.putString("country", country)
            editor.putBoolean("isAdult", isAdult)
            editor.apply()
        }

        binding.btnLoad.setOnClickListener {
            keyBoard.hideSoftInputFromWindow(it.windowToken, 0)
            val name = sharedPref.getString("name", "")
            val country = sharedPref.getString("country", "")
            val isAdult = sharedPref.getBoolean("isAdult", false)
            updateTextView(binding.tvName, name, binding.tvNameHeading)
            updateTextView(binding.tvCountry, country, binding.tvCountryHeading)
            updateTextView(
                binding.tvIsAdult,
                if (isAdult) "Yes" else "No",
                binding.tvIsAdultHeading,
                name.isNullOrEmpty() || country.isNullOrEmpty()
            )
        }
    }

    private fun updateTextView(
        textView: TextView,
        text: String?,
        heading: TextView,
        isEmpty: Boolean = text.isNullOrEmpty()
    ) {
        textView.apply {
            this.text = text
            visibility = if (isEmpty) View.GONE else View.VISIBLE
        }
        heading.visibility = if (isEmpty) View.GONE else View.VISIBLE
    }
}