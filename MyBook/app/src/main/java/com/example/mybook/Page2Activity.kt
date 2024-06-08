package com.example.mybook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mybook.databinding.ActivityPage2Binding

class Page2Activity : AppCompatActivity() {
    private lateinit var b: ActivityPage2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_page2)
        b.page2 = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clPage2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option =
            arrayOf("Page One", "Page Three", "Page Four", "Page Five", "Close Book", "Close App")
        val singleChoiceAlertDialogBox = AlertDialog.Builder(this)
            .setTitle("Choose one of this option")
            .setSingleChoiceItems(option, 1, null)
            .setPositiveButton("Go") { dialog, _ ->
                val selectPosition = (dialog as AlertDialog).listView.checkedItemPosition
                when (selectPosition) {
                    0 -> backNavigate(Page1Activity::class.java)
                    1 -> navigate(Page3Activity::class.java)
                    2 -> navigate(Page4Activity::class.java)
                    3 -> navigate(Page5Activity::class.java)
                    4 -> closeBook()
                    5 -> finishAffinity()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .create()

        b.btnOptionPage2.setOnClickListener {
            singleChoiceAlertDialogBox.show()
        }
    }

    private fun navigate(activityClass: Class<*>) {
        Intent(this, activityClass).also {
            startActivity(it)
        }
    }

    private fun backNavigate(activityClass: Class<*>) {
        Intent(this, activityClass).also {
            it.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(it)
            finish()
        }
    }

    private fun closeBook() {
        Intent(this, MainActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Intent(this, Page1Activity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(it)
            finish()
        }
    }
}