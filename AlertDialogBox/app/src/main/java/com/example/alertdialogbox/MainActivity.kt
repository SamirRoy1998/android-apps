package com.example.alertdialogbox

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.alertdialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.acFirst = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addContactDialogBox = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add this person to your contacts list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnFirstDailog.setOnClickListener {
            addContactDialogBox.show()
        }

        val option =
            arrayOf("0th", "1st", "2nd", "3rd")
        val singleChoiceDialogBox = AlertDialog.Builder(this)
            .setTitle("Choose one of this option")
            .setSingleChoiceItems(option, 1) { _, i ->
                Toast.makeText(this, "You clicked on ${option[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted single choice dialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined single choice dialog", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnSecondDailog.setOnClickListener {
            singleChoiceDialogBox.show()
        }

        val multiChoiceDialogBox = AlertDialog.Builder(this)
            .setTitle("Chose as you want")
            .setMultiChoiceItems(
                option,
                booleanArrayOf(
                    false,
                    false,
                    false,
                    false
                )
            ) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${option[i]}", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this, "You unchecked ${option[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Done") { _, _ ->
                Toast.makeText(this, "You accepted multi choice dialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(this, "You canceled multi choice dialog", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnThirdDailog.setOnClickListener {
            multiChoiceDialogBox.show()
        }
    }
}