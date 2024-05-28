package com.example.binding

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val f = false

    private var n = Name("Name: ")
    private var a: Age = Age("Age: ")
    private var add = Address("Address: ")
    private var ph = PhoneNumber("Phone Number: ")
    private var txt = Text(
        heading = "Fill up the form",
        buttonName = "Submit",)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (f) {
            setContentView(R.layout.activity_main)
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.nameField = n
        binding.ageField = a
        binding.addressField = add
        binding.phoneNumberField = ph
        binding.autoText = txt

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnSubmit.setOnClickListener {
            if (f) {
                submit()
            }
            newSubmit()
        }
    }

    private fun submit() {
        val heading = "Your form submitted"
        binding.apply {

            txtName.text = editName.text
            txtAge.text = editAge.text
            txtAddress.text = editAddress.text
            txtPhoneNumber.text = editPhoneNumber.text
            txtHeading.text = heading
            invalidateAll()

            editName.visibility = View.GONE
            editAge.visibility = View.GONE
            editAddress.visibility = View.GONE
            editPhoneNumber.visibility = View.GONE
            btnSubmit.visibility = View.GONE

            txtName.visibility = View.VISIBLE
            txtAge.visibility = View.VISIBLE
            txtAddress.visibility = View.VISIBLE
            txtPhoneNumber.visibility = View.VISIBLE

            val kb = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            kb.hideSoftInputFromWindow(editName.windowToken, 0)
            kb.hideSoftInputFromWindow(editAge.windowToken, 0)
            kb.hideSoftInputFromWindow(editAddress.windowToken, 0)
            kb.hideSoftInputFromWindow(editPhoneNumber.windowToken, 0)
        }
    }

    private fun newSubmit() {
        val heading = "Your form submitted"
        binding.apply {

            nameField?.userName = editName.text.toString()
            ageField?.userAge = editAge.text.toString()
            addressField?.userAddress = editAddress.text.toString()
            phoneNumberField?.userPhoneNumber = editPhoneNumber.text.toString()
            txtHeading.text = heading
            invalidateAll()

            editName.visibility = View.GONE
            editAge.visibility = View.GONE
            editAddress.visibility = View.GONE
            editPhoneNumber.visibility = View.GONE
            btnSubmit.visibility = View.GONE

            txtName.visibility = View.VISIBLE
            txtAge.visibility = View.VISIBLE
            txtAddress.visibility = View.VISIBLE
            txtPhoneNumber.visibility = View.VISIBLE

            val kb = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            kb.hideSoftInputFromWindow(editName.windowToken, 0)
            kb.hideSoftInputFromWindow(editAge.windowToken, 0)
            kb.hideSoftInputFromWindow(editAddress.windowToken, 0)
            kb.hideSoftInputFromWindow(editPhoneNumber.windowToken, 0)
        }
    }
}