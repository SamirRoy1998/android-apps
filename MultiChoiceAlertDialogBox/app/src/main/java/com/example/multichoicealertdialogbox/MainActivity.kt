package com.example.multichoicealertdialogbox

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.multichoicealertdialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var originalText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_main)
        b.mainLayout = this
        ViewCompat.setOnApplyWindowInsetsListener(b.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        originalText = b.txtResult.text.toString()
        val meal = arrayOf("Rice", "Dall", "Papad", "Veg Curry", "Paneer Kofta")
        val selectedItems = booleanArrayOf(true, false, false, false, false)
        val multiChoiceAlertDialog = AlertDialog.Builder(this)
            .setTitle("Choose your meal")
            .setMultiChoiceItems(meal, selectedItems) { _, index, isChecked ->
                selectedItems[index] = isChecked
            }
            .setPositiveButton("Order") { dialog, _ ->
                val selectedMeal = meal.filterIndexed { i, _ -> selectedItems[i] }
                b.txtResult.text = selectedMeal.joinToString(", ")
                b.txtResult.visibility = View.VISIBLE
                dialog.dismiss()
            }
            .setNegativeButton("Decline") { dialog, _ ->
                b.txtResult.text = originalText
                b.txtResult.visibility = View.VISIBLE
                selectedItems.fill(false)
                dialog.dismiss()
            }
            .create()

        b.btnOption.setOnClickListener {
            multiChoiceAlertDialog.show()
        }
    }
}