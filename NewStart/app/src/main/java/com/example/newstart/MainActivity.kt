package com.example.newstart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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
    private lateinit var getContent: ActivityResultLauncher<String>
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

        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                navigateToSubmittedPage(it.toString())
            } ?: Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show()
        }

        binding.btnClear.setOnClickListener {
            hideKeyboard(it)
            clearText()
        }

        binding.btnSubmit.setOnClickListener {
            if (collectInputData()) {
                try {
                    Toast.makeText(
                        this,
                        "Choose a profile picture to submit your application",
                        Toast.LENGTH_LONG
                    ).show()
                    getContent.launch("image/*")
                } catch (e: Exception) {
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
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

    private fun collectInputData(): Boolean {
        firstName = binding.etFirstName.text.toString()
        lastName = binding.etLastName.text.toString()
        address = binding.etAddress.text.toString()
        country = binding.etCountry.text.toString()
        pinCode = binding.etPinCode.text.toString()
        dateOfBirth = binding.etDateOfBirth.text.toString()
        bloodGroup = binding.etBloodGroup.text.toString()
        phoneNumber = binding.etContactNumber.text.toString()

        return firstName.isNotBlank() &&
                lastName.isNotBlank() &&
                address.isNotBlank() &&
                country.isNotBlank() &&
                pinCode.isNotBlank() &&
                dateOfBirth.isNotBlank() &&
                bloodGroup.isNotBlank() &&
                phoneNumber.isNotBlank()
    }

    private fun navigateToSubmittedPage(imageUri: String) {
        val intent = Intent(this, SubmittedPageActivity::class.java).apply {
            putExtra("EXTRA_IMAGE", imageUri)
            putExtra("EXTRA_FIRST_NAME", firstName)
            putExtra("EXTRA_LAST_NAME", lastName)
            putExtra("EXTRA_ADDRESS", address)
            putExtra("EXTRA_COUNTRY", country)
            putExtra("EXTRA_PIN_CODE", pinCode)
            putExtra("EXTRA_DATE_OF_BIRTH", dateOfBirth)
            putExtra("EXTRA_BLOOD_GROUP", bloodGroup)
            putExtra("EXTRA_PHONE_NUMBER", phoneNumber)
        }
        startActivity(intent)
    }
}