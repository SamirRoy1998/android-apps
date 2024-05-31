package com.example.calculator

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val f = false
    private lateinit var binding: ActivityMainBinding

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

        binding.btnClear.setOnClickListener {
            clearResult()
        }

        binding.btnAddition.setOnClickListener {
            addition()
        }

        binding.btnSubtraction.setOnClickListener {
            subtraction()
        }

        binding.btnMultiplication.setOnClickListener {
            multiplication()
        }

        binding.btnDivision.setOnClickListener {
            division()
        }
    }

    private fun clearResult() {
        val key = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        key.hideSoftInputFromWindow(binding.etInputX.windowToken, 0)
        key.hideSoftInputFromWindow(binding.etInputY.windowToken, 0)

        val result = "Result : "
        binding.txtResult.text = result
        Toast.makeText(this, "Result Cleared", Toast.LENGTH_SHORT).show()
    }

    private fun addition() {
        val key = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        key.hideSoftInputFromWindow(binding.etInputX.windowToken, 0)
        key.hideSoftInputFromWindow(binding.etInputY.windowToken, 0)

        try {
            val x = binding.etInputX.text.toString()
            val y = binding.etInputY.text.toString()
            val z = x.toDouble() + y.toDouble()
            binding.txtResult.text = "Result : $z"
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Please fill-up the X and Y both inputs\nto get result",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun subtraction() {
        val key = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        key.hideSoftInputFromWindow(binding.etInputX.windowToken, 0)
        key.hideSoftInputFromWindow(binding.etInputY.windowToken, 0)

        try {
            val x = binding.etInputX.text.toString()
            val y = binding.etInputY.text.toString()
            val z = x.toDouble() - y.toDouble()
            binding.txtResult.text = "Result : $z"
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Please fill-up the X and Y both inputs\nto get result",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun multiplication() {
        val key = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        key.hideSoftInputFromWindow(binding.etInputX.windowToken, 0)
        key.hideSoftInputFromWindow(binding.etInputY.windowToken, 0)

        try {
            val x = binding.etInputX.text.toString()
            val y = binding.etInputY.text.toString()
            val z = x.toDouble() * y.toDouble()
            binding.txtResult.text = "Result : $z"
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Please fill-up the X and Y both inputs\nto get result",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun division() {
        val key = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        key.hideSoftInputFromWindow(binding.etInputX.windowToken, 0)
        key.hideSoftInputFromWindow(binding.etInputY.windowToken, 0)

        try {
            val x = binding.etInputX.text.toString()
            val y = binding.etInputY.text.toString()
            val z = x.toDouble() / y.toDouble()
            if (x.toDouble() == 0.0 || y.toDouble() == 0.0) {
                binding.txtResult.text = "Result : 0"
            } else {
                binding.txtResult.text = "Result : $z"
            }
        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Please fill-up the X and Y both inputs\nto get result",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
