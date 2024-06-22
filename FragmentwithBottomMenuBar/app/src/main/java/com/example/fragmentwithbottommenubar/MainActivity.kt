package com.example.fragmentwithbottommenubar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.fragmentwithbottommenubar.databinding.ActivityMainBinding

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
        val home = HomeFragment()
        val message = MessageFragment()
        val profile = ProfileFragment()

        setCurrentFragment(home)
        b.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> {
                    setCurrentFragment(home)
                    Toast.makeText(this, "Testing", Toast.LENGTH_SHORT).show()
                }
                R.id.miMessage -> setCurrentFragment(message)
                R.id.miProfile -> setCurrentFragment(profile)
            }
            true
        }
        b.bottomNavigationView.getOrCreateBadge(R.id.miMessage).apply {
            number = 10
            isVisible = true
        }
    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}