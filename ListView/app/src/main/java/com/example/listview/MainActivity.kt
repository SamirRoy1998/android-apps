package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private val personData = PersonData()
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

        val personStrings = personData.data2.map { person ->
            "${person.name}\nID: ${person.id}, Age: ${person.age}"
        }.toTypedArray()

        val customAdapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, personData.data1)
        val customAdapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, personStrings)
        b.lvMain.adapter = customAdapter2
        b.lvMain.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = personStrings[position]
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
        }
    }
}