package com.example.multipleactivities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.multipleactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        binding.secondPage = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clsSecondActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnA2toA1.setOnClickListener {
            finish()
        }

        binding.btnA2toA3.setOnClickListener {
            Intent(this, ThirdActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}