package com.example.practice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
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
        val first = FirstFragment()
        val second = SecondFragment()
        setCurrentFragment(first)

        b.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.miFirst -> {
                    setCurrentFragment(first)
                    Toast.makeText(this, "Testing", Toast.LENGTH_SHORT).show()
                }
                R.id.miSecond -> setCurrentFragment(second)
            }
            true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(b.flFragment.id, fragment)
            commit()
        }

    fun getFragmentContainerId(): Int {
        return b.flFragment.id
    }
}