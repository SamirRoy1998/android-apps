package com.example.viewpagerwithtablayout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.viewpagerwithtablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val storage = Storage()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainLayout = this
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        viewPager.adapter = VpAdapter(storage.images)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "${position + 1}"
        }.attach()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"you selected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?){

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"you reselected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }
        })
    }
}