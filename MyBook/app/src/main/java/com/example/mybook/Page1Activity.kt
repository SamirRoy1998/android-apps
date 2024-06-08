package com.example.mybook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mybook.databinding.ActivityPage1Binding

class Page1Activity : AppCompatActivity() {
    private lateinit var b: ActivityPage1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_page1)
        b.page1 = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clPage1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option =
            arrayOf("Page Two", "Page Three", "Page Four", "Page Five", "Close Book", "Close App")
        val singleChoiceDialogBox = AlertDialog.Builder(this)
            .setTitle("Choose one of this option")
            .setSingleChoiceItems(option, 0, null)
            .setPositiveButton("Go") { dialog, _ ->
                val selectPosition = (dialog as AlertDialog).listView.checkedItemPosition
                when (selectPosition) {
                    0 -> navigate(Page2Activity::class.java)
                    1 -> navigate(Page3Activity::class.java)
                    2 -> navigate(Page4Activity::class.java)
                    3 -> navigate(Page5Activity::class.java)
                    4 -> finish()
                    5 -> finishAffinity()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .create()

        b.btnOptionPage1.setOnClickListener {
            singleChoiceDialogBox.show()
        }
    }

    private fun navigate(activityClass: Class<*>) {
        Intent(this, activityClass).also {
            startActivity(it)
        }
    }
}