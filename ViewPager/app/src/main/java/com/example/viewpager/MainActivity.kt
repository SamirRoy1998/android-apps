package com.example.viewpager

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private val images = listOf(
        R.drawable.man1,
        R.drawable.woman1,
        R.drawable.man2,
        R.drawable.woman2,
        R.drawable.man3,
        R.drawable.woman3,
        R.drawable.man4,
        R.drawable.woman4,
        R.drawable.man5,
        R.drawable.woman5,
        R.drawable.man6,
        R.drawable.woman6,
        R.drawable.man7,
        R.drawable.woman7,
        R.drawable.man8,
        R.drawable.woman8,
        R.drawable.man9,
        R.drawable.woman9,
        R.drawable.man10,
        R.drawable.woman10,
    )
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
        b.vpMain.adapter= ViewPagerAdapter(images)
    }
}