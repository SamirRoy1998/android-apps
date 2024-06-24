package com.example.newstart

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
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
    private var firstName = ""
    private var lastName = ""
    private var address = ""
    private var country = ""
    private var pinCode = ""
    private var dateOfBirth = ""
    private var bloodGroup = ""
    private var phoneNumber = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.firstActivity = this
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnClear.setOnClickListener {
            hideKeyboard(it)
            clearText()
        }

        binding.btnSubmit.setOnClickListener {
            firstName = binding.etFirstName.text.toString()
            lastName = binding.etLastName.text.toString()
            address = binding.etAddress.text.toString()
            country = binding.etCountry.text.toString()
            pinCode = binding.etPinCode.text.toString()
            dateOfBirth = binding.etDateOfBirth.text.toString()
            bloodGroup = binding.etBloodGroup.text.toString()
            phoneNumber = binding.etContactNumber.text.toString()

            if (firstName.isBlank() || lastName.isBlank() || address.isBlank() || country.isBlank() ||
                pinCode.isBlank() || dateOfBirth.isBlank() || bloodGroup.isBlank() || phoneNumber.isBlank()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                Intent(Intent.ACTION_GET_CONTENT).also {
                    it.type = "image/*"

                    startActivityForResult(it, 0)
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            val imageUri = data?.data
            Intent(this, SubmittedPageActivity::class.java).also {
                it.putExtra("EXTRA_IMAGE", imageUri.toString())
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
        }
    }

    private fun hideKeyboard(view: View){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun clearText() {
        with(binding) {
            etFirstName.text.clear()
            etLastName.text.clear()
            etAddress.text.clear()
            etPinCode.text.clear()
            etCountry.text.clear()
            etBloodGroup.text.clear()
            etDateOfBirth.text.clear()
            etContactNumber.text.clear()
        }
    }
}