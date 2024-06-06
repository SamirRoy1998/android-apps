package com.example.multipleactivities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.multipleactivities.databinding.ActivityForthBinding

class ForthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_forth)
        binding.forthPage = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clsForthActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnA4toA3.setOnClickListener {
            finish()
        }

        binding.btnA4toA1.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
                finish()
            }
        }

        binding.btnA4toA2.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(it)
                finish()
            }
        }

        binding.btnA4toA5.setOnClickListener {
            Intent(this, FifthActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}