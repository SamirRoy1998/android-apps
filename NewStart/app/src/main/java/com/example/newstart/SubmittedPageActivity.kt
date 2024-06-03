package com.example.newstart

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submitted_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clSubmittedPage)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val firstName = intent.getStringExtra("EXTRA_FIRST_NAME")
        val lastName = intent.getStringExtra("EXTRA_LAST_NAME")
        val address = intent.getStringExtra("EXTRA_ADDRESS")
        val country = intent.getStringExtra("EXTRA_COUNTRY")
        val pinCode = intent.getStringExtra("EXTRA_PIN_CODE")
        val dateOfBirth = intent.getStringExtra("EXTRA_DATE_OF_BIRTH")
        val bloodGroup = intent.getStringExtra("EXTRA_BLOOD_GROUP")
        val phoneNumber = intent.getStringExtra("EXTRA_PHONE_NUMBER")

        binding.txtA2Name.text = firstName + " " + lastName
        binding.txtA2Address.text = address + ", " + country + " -" + pinCode.toString()
        binding.txtA2DateOfBirth.text = dateOfBirth
        binding.txtA2BloodGroup.text = bloodGroup
        binding.txtA2PhoneNumber.text = phoneNumber

        binding.btnA2Edit.setOnClickListener {
            finish()
        }
        binding.btnA2Apply.setOnClickListener {
            Toast.makeText(this, "Thank you for Applying", Toast.LENGTH_LONG).show()
        }
    }
}