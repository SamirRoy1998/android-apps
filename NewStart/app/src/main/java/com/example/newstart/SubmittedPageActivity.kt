package com.example.newstart

import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.newstart.databinding.ActivitySubmittedPageBinding

class SubmittedPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmittedPageBinding

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private var finalFirstName = ""
    private var finalLastName = ""
    private var finalAddress = ""
    private var finalCountry = ""
    private var finalPinCode = ""
    private var finalDateOfBirth = ""
    private var finalBloodGroup = ""
    private var finalPhoneNumber = ""
    private var finalImage = ""

    private var firstName = ""
    private var lastName = ""
    private var address = ""
    private var country = ""
    private var pinCode = ""
    private var dateOfBirth = ""
    private var bloodGroup = ""
    private var phoneNumber = ""
    private var image = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submitted_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clSubmittedPage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPreferences = getSharedPreferences("NewPref", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        firstName = intent.getStringExtra("EXTRA_FIRST_NAME") ?: ""
        lastName = intent.getStringExtra("EXTRA_LAST_NAME") ?: ""
        address = intent.getStringExtra("EXTRA_ADDRESS") ?: ""
        country = intent.getStringExtra("EXTRA_COUNTRY") ?: ""
        pinCode = intent.getStringExtra("EXTRA_PIN_CODE") ?: ""
        dateOfBirth = intent.getStringExtra("EXTRA_DATE_OF_BIRTH") ?: ""
        bloodGroup = intent.getStringExtra("EXTRA_BLOOD_GROUP") ?: ""
        phoneNumber = intent.getStringExtra("EXTRA_PHONE_NUMBER") ?: ""
        image = intent.getStringExtra("EXTRA_IMAGE") ?: ""

        if (firstName.isNotEmpty()) {
            saveData()
            loadData()

            val finalImageUri = Uri.parse(finalImage)

            binding.txtA2Name.text = finalFirstName + " " + finalLastName
            binding.txtA2Address.text = finalAddress + ", " + finalCountry + " -" + finalPinCode
            binding.txtA2DateOfBirth.text = finalDateOfBirth
            binding.txtA2BloodGroup.text = finalBloodGroup
            binding.txtA2PhoneNumber.text = finalPhoneNumber
            binding.ivUserPhoto.setImageURI(finalImageUri)
        } else {
            loadData()
            val finalImageUri = Uri.parse(finalImage)

            binding.txtA2Name.text = finalFirstName + " " + finalLastName
            binding.txtA2Address.text = finalAddress + ", " + finalCountry + " -" + finalPinCode
            binding.txtA2DateOfBirth.text = finalDateOfBirth
            binding.txtA2BloodGroup.text = finalBloodGroup
            binding.txtA2PhoneNumber.text = finalPhoneNumber
            binding.ivUserPhoto.setImageURI(finalImageUri)
        }

        binding.btnA2Edit.setOnClickListener {
            finish()
        }
        binding.btnA2Apply.setOnClickListener {
            Toast.makeText(this, "Thank you for Applying", Toast.LENGTH_LONG).show()
        }
    }

    private fun saveData() {
        editor.putString("FINAL_FIRST_NAME", firstName)
        editor.putString("FINAL_LAST_NAME", lastName)
        editor.putString("FINAL_ADDRESS", address)
        editor.putString("FINAL_COUNTRY", country)
        editor.putString("FINAL_PIN_CODE", pinCode)
        editor.putString("FINAL_DATE_OF_BIRTH", dateOfBirth)
        editor.putString("FINAL_BLOOD_GROUP", bloodGroup)
        editor.putString("FINAL_PHONE_NUMBER", phoneNumber)
        editor.putString("FINAL_IMAGE", image)
        editor.apply()
    }

    private fun loadData() {
        finalFirstName = sharedPreferences.getString("FINAL_FIRST_NAME", "") ?: ""
        finalLastName = sharedPreferences.getString("FINAL_LAST_NAME", "") ?: ""
        finalAddress = sharedPreferences.getString("FINAL_ADDRESS", "") ?: ""
        finalCountry = sharedPreferences.getString("FINAL_COUNTRY", "") ?: ""
        finalPinCode = sharedPreferences.getString("FINAL_PIN_CODE", "") ?: ""
        finalDateOfBirth = sharedPreferences.getString("FINAL_DATE_OF_BIRTH", "") ?: ""
        finalBloodGroup = sharedPreferences.getString("FINAL_BLOOD_GROUP", "") ?: ""
        finalPhoneNumber = sharedPreferences.getString("FINAL_PHONE_NUMBER", "") ?: ""
        finalImage = sharedPreferences.getString("FINAL_IMAGE", "") ?: ""
    }
}