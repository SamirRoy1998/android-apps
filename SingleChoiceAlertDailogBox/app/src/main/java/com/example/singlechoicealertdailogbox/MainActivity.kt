package com.example.singlechoicealertdailogbox

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.singlechoicealertdailogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_main)
        b.mainLayout = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val color = arrayOf("Red", "Blue", "Green", "Yellow", "Pink")
        val singleChoiceAlertDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of this option")
            .setSingleChoiceItems(color, 1, null)
            .setPositiveButton("Accept") { dialog, _ ->
                val selectedPosition = (dialog as AlertDialog).listView.checkedItemPosition
                when (selectedPosition) {
                    0 -> b.txtResult.text = "Red"
                    1 -> b.txtResult.text = "Blue"
                    2 -> b.txtResult.text = "Green"
                    3 -> b.txtResult.text = "Yellow"
                    4 -> b.txtResult.text = "Pink"
                }
                b.txtResult.visibility = View.VISIBLE
                dialog.dismiss()
            }
            .setNegativeButton("Decline", null)
            .create()

        b.btnOption.setOnClickListener {
            singleChoiceAlertDialog.show()
        }
    }
}