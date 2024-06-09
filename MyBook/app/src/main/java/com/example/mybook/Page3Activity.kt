package com.example.mybook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mybook.databinding.ActivityPage3Binding

class Page3Activity : AppCompatActivity() {
    private lateinit var b: ActivityPage3Binding
    private val n = Navigation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_page3)
        b.page3 = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clPage3)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option =
            arrayOf("Page One", "Page Two", "Page Four", "Page Five", "Close Book", "Close App")
        val optionAlertDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of this option")
            .setSingleChoiceItems(option, 2, null)
            .setPositiveButton("Go") { dialog, _ ->
                val selectPosition = (dialog as AlertDialog).listView.checkedItemPosition
                when (selectPosition) {
                    0 -> n.nav(this,Page1Activity::class.java)
                    1 -> n.nav(this,Page2Activity::class.java)
                    2 -> n.nav(this,Page4Activity::class.java)
                    3 -> n.nav(this,Page5Activity::class.java)
                    4 -> n.nav(this,MainActivity::class.java)
                    5 -> finishAffinity()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .create()

        b.btnOptionPage3.setOnClickListener {
            optionAlertDialog.show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Intent(this, Page2Activity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
            finish()
        }
    }
}