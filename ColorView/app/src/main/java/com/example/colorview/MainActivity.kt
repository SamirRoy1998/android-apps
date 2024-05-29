package com.example.colorview

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.colorview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var f = false
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
        setListeners()
        if (f) {
            binding.btn1.setOnClickListener {
                binding.txtBox1.setBackgroundColor(Color.YELLOW)
            }
            binding.btn2.setOnClickListener {
                binding.txtBox2.setBackgroundColor(Color.GREEN)
            }
            binding.btn3.setOnClickListener {
                binding.txtBox3.setBackgroundColor(Color.RED)
            }
            binding.btn4.setOnClickListener {
                binding.txtBox4.setBackgroundColor(Color.BLUE)
            }
            binding.btn5.setOnClickListener {
                binding.txtBox5.setBackgroundColor(Color.MAGENTA)
            }
        }
    }

    private fun setListeners() {
        val clickableView: List<View> = listOf(
            binding.txtBox1,
            binding.txtBox2,
            binding.txtBox3,
            binding.txtBox4,
            binding.txtBox5,
            binding.main,
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5
        )
        for (item in clickableView) {
            item.setOnClickListener {
                makeColor(it)
            }
        }
    }

    private fun makeColor(view: View) {
        when (view.id) {
            R.id.txtBox1 -> view.setBackgroundColor(Color.GRAY)
            R.id.txtBox2 -> view.setBackgroundColor(Color.BLUE)
            R.id.txtBox3 -> view.setBackgroundColor(Color.CYAN)
            R.id.txtBox4 -> view.setBackgroundColor(Color.MAGENTA)
            R.id.txtBox5 -> view.setBackgroundColor(Color.GREEN)
            R.id.main -> view.setBackgroundColor(Color.DKGRAY)
            R.id.btn1 -> binding.txtBox1.setBackgroundColor(Color.YELLOW)
            R.id.btn2 -> binding.txtBox2.setBackgroundColor(Color.GREEN)
            R.id.btn3 -> binding.txtBox3.setBackgroundColor(Color.RED)
            R.id.btn4 -> binding.txtBox4.setBackgroundColor(Color.BLUE)
            R.id.btn5 -> binding.txtBox5.setBackgroundColor(Color.MAGENTA)
        }
    }
}