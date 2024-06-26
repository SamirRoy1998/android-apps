package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val f = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (f) {
            setContentView(R.layout.activity_main)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (f) {
            val submit = findViewById<Button>(R.id.btn_submit)
            submit.setOnClickListener {
                setSuggestion()
            }
        }

        binding.btnSubmit.setOnClickListener {
            if (f) {
                setSuggestionWithDataBinding()
            }

            newSetSuggestionWithDataBinding()
        }
    }

    private fun setSuggestion() {
        val heading = findViewById<TextView>(R.id.txt_main_suggestion_heading)
        val editText = findViewById<EditText>(R.id.editText)
        val suggestion = findViewById<TextView>(R.id.txt_main_suggestion)
        suggestion.text = editText.text
        editText.visibility = View.GONE
        findViewById<Button>(R.id.btn_submit).visibility = View.GONE
        suggestion.visibility = View.VISIBLE
        val newHeading = "Your suggestion posted"
        heading.text = newHeading

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)
    }

    private fun setSuggestionWithDataBinding() {
        binding.txtMainSuggestion.text = binding.editText.text
        binding.editText.visibility = View.GONE
        binding.btnSubmit.visibility = View.GONE
        binding.txtMainSuggestion.visibility = View.VISIBLE
        val newHeading = "Your suggestion posted"
        binding.txtMainSuggestionHeading.text = newHeading

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.editText.windowToken, 0)
    }

    private fun newSetSuggestionWithDataBinding() {
        binding.apply {
            txtMainSuggestion.text = editText.text
            editText.visibility = View.GONE
            btnSubmit.visibility = View.GONE
            txtMainSuggestion.visibility = View.VISIBLE
            val newHeading = "Your suggestion posted"
            txtMainSuggestionHeading.text = newHeading

            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)
        }
    }
}
