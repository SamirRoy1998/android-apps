package com.example.foodorder

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
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
            try {
                val checkedSize = binding.radioGroup3.checkedRadioButtonId
                val size = findViewById<RadioButton>(checkedSize)

                val checkedItem = binding.radioGroup2.checkedRadioButtonId
                val item = findViewById<RadioButton>(checkedItem)

                val mutton = binding.cbMutton.isChecked
                val chicken = binding.cbChicken.isChecked
                val egg = binding.cbEgg.isChecked
                val paneer = binding.cbPaneer.isChecked
                val onionRings = binding.cbOnionRings.isChecked
                val mushroom = binding.cbMushroom.isChecked
                val capsicum = binding.cbCapsicum.isChecked

                val orderList = "Your ordered\n" +
                        "A ${size.text} size ${item.text}" +
                        (if (mutton) "\n• Mutton Pakoda" else "") +
                        (if (chicken) "\n• Chicken Pakoda" else "") +
                        (if (egg) "\n• Egg Bhurji" else "") +
                        (if (paneer) "\n• Paneer" else "") +
                        (if (onionRings) "\n• Onion Rings" else "") +
                        (if (mushroom) "\n• Mushroom" else "") +
                        (if (capsicum) "\n• Capsicum" else "")

                binding.txtOrderDetails.text = orderList
                Toast(this).apply {
                    duration = Toast.LENGTH_LONG
                    view = layoutInflater.inflate(
                        R.layout.activity_custom_toast_order_done,
                        findViewById(R.id.clCustomToast)
                    )
                    show()
                }
            } catch (e: Exception) {
                binding.txtOrderDetails.text = "Select Any Item\nAnd Size Too!!!"
            }
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
        binding.cbEgg.visibility = View.GONE
        binding.cbChicken.visibility = View.GONE
        binding.cbMutton.visibility = View.GONE

        binding.cbOnionRings.isChecked = false
        binding.cbEgg.isChecked = false
        binding.cbChicken.isChecked = false
        binding.cbMutton.isChecked = false
        return true
    }

    private fun showNonVeg(): Boolean {
        binding.cbOnionRings.visibility = View.VISIBLE
        binding.cbEgg.visibility = View.VISIBLE
        binding.cbChicken.visibility = View.VISIBLE
        binding.cbMutton.visibility = View.VISIBLE
        return true
    }
}
