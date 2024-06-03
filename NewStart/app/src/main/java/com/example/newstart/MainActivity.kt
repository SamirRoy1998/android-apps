package com.example.newstart

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.newstart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.firstActivity = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnClear.setOnClickListener {
            val x = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            x.hideSoftInputFromWindow(binding.etFirstName.windowToken, 0)
            x.hideSoftInputFromWindow(binding.etLastName.windowToken, 0)
            x.hideSoftInputFromWindow(binding.etAddress.windowToken, 0)
            x.hideSoftInputFromWindow(binding.etPinCode.windowToken, 0)
            x.hideSoftInputFromWindow(binding.etCountry.windowToken, 0)
            x.hideSoftInputFromWindow(binding.etBloodGroup.windowToken, 0)
            x.hideSoftInputFromWindow(binding.etDateOfBirth.windowToken, 0)
            x.hideSoftInputFromWindow(binding.etContactNumber.windowToken, 0)

            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()
            binding.etAddress.text.clear()
            binding.etPinCode.text.clear()
            binding.etCountry.text.clear()
            binding.etBloodGroup.text.clear()
            binding.etDateOfBirth.text.clear()
            binding.etContactNumber.text.clear()

        }

        binding.btnSubmit.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val address = binding.etAddress.text.toString()
            val country = binding.etCountry.text.toString()
            val pinCode = binding.etPinCode.text.toString()
            val dateOfBirth = binding.etDateOfBirth.text.toString()
            val bloodGroup = binding.etBloodGroup.text.toString()
            val phoneNumber = binding.etContactNumber.text.toString()

            if (firstName.isBlank() || lastName.isBlank() || address.isBlank() || country.isBlank() ||
                pinCode.isBlank() || dateOfBirth.isBlank() || bloodGroup.isBlank() || phoneNumber.isBlank()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                Intent(this, SubmittedPageActivity::class.java).also {
                    it.putExtra("EXTRA_FIRST_NAME", firstName)
                    it.putExtra("EXTRA_LAST_NAME", lastName)
                    it.putExtra("EXTRA_ADDRESS", address)
                    it.putExtra("EXTRA_COUNTRY", country)
                    it.putExtra("EXTRA_PIN_CODE", pinCode)
                    it.putExtra("EXTRA_DATE_OF_BIRTH", dateOfBirth)
                    it.putExtra("EXTRA_BLOOD_GROUP", bloodGroup)
                    it.putExtra("EXTRA_PHONE_NUMBER", phoneNumber)
                    startActivity(it)
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}