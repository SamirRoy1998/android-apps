package com.example.mybook

import android.content.Intent
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
            .setSingleChoiceItems(option, 0) { _, _ ->
            }
            .setPositiveButton("Go") { dialog, _ ->
                val selectedPosition = (dialog as AlertDialog).listView.checkedItemPosition
                if (selectedPosition == 0) {
                    pageOne()
                }
                dialog.dismiss()
                if (selectedPosition == 1) {
                    pageTwo()
                }
                dialog.dismiss()
                if (selectedPosition == 2) {
                    pageThree()
                }
                dialog.dismiss()
                if (selectedPosition == 3) {
                    pageFour()
                }
                dialog.dismiss()
                if (selectedPosition == 4) {
                    pageFive()
                }
                dialog.dismiss()
                if (selectedPosition == 5) {
                    finish()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel"){_,_->}

        b.btnOptionCover.setOnClickListener {
            singleChoiceDialogBox.show()
        }
    }

    private fun pageOne() {
        Intent(this, Page1Activity::class.java).also {
            startActivity(it)
        }
    }

    private fun pageTwo() {
        Intent(this, Page2Activity::class.java).also {
            startActivity(it)
        }
    }

    private fun pageThree() {
        Intent(this, Page3Activity::class.java).also {
            startActivity(it)
        }
    }

    private fun pageFour() {
        Intent(this, Page4Activity::class.java).also {
            startActivity(it)
        }
    }

    private fun pageFive() {
        Intent(this, Page5Activity::class.java).also {
            startActivity(it)
        }
    }
}