package com.example.foodorder

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.foodorder.databinding.ActivityMainBinding

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

        binding.btnOrder.setOnClickListener {
            Toast.makeText(this, "App is running", Toast.LENGTH_SHORT).show()
        }

        hideNonVeg()

        binding.rbR1Veg.setOnClickListener {
            binding.rbR1Veg.isChecked = hideNonVeg()
        }
        binding.rbR1NonVeg.setOnClickListener {
            binding.rbR1NonVeg.isChecked = showNonVeg()
        }
    }

    private fun hideNonVeg(): Boolean {
        binding.cbOnionRings.visibility = View.GONE
        binding.cbEgg.visibility =View.GONE
        binding.cbChicken.visibility =View.GONE
        binding.cbMutton.visibility =View.GONE
        return true
    }

    private fun showNonVeg(): Boolean {
        binding.cbOnionRings.visibility = View.VISIBLE
        binding.cbEgg.visibility =View.VISIBLE
        binding.cbChicken.visibility =View.VISIBLE
        binding.cbMutton.visibility =View.VISIBLE
        return true
    }
}
