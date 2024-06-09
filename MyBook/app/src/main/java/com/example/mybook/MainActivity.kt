package com.example.mybook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mybook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private val n = Navigation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_main)
        b.cover = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option = arrayOf("Page One", "Page Two", "Page Three", "Page Four", "Page Five", "Close App")
        val singleChoiceDialogBox = AlertDialog.Builder(this)
            .setTitle("Choose one of this option ")
            .setSingleChoiceItems(option, 0, null)
            .setPositiveButton("Go") { dialog, _ ->
                val selectedPosition = (dialog as AlertDialog).listView.checkedItemPosition
                when (selectedPosition) {
                    0 -> n.nav(this, Page1Activity::class.java)
                    1 -> n.nav(this, Page2Activity::class.java)
                    2 -> n.nav(this, Page3Activity::class.java)
                    3 -> n.nav(this, Page4Activity::class.java)
                    4 -> n.nav(this, Page5Activity::class.java)
                    5 -> finishAffinity()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .create()

        b.btnOptionCover.setOnClickListener {
            singleChoiceDialogBox.show()
        }
    }
}