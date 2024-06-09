package com.example.mybook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mybook.databinding.ActivityPage5Binding

class Page5Activity : AppCompatActivity() {
    private lateinit var b: ActivityPage5Binding
    private val n = Navigation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = DataBindingUtil.setContentView(this, R.layout.activity_page5)
        b.page5 = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.clPage5)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val option =
            arrayOf("Page One", "Page Two", "Page Three", "Page Four", "Close Book", "Close App")
        val optionAlertDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of this option")
            .setSingleChoiceItems(option, 4, null)
            .setPositiveButton("Go") { dialog, _ ->
                val selectPosition = (dialog as AlertDialog).listView.checkedItemPosition
                when (selectPosition) {
                    0 -> n.nav(this, Page1Activity::class.java)
                    1 -> n.nav(this, Page2Activity::class.java)
                    2 -> n.nav(this, Page3Activity::class.java)
                    3 -> n.nav(this, Page4Activity::class.java)
                    4 -> n.nav(this, MainActivity::class.java)
                    5 -> finishAffinity()
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel", null)
            .create()

        b.btnOptionPage5.setOnClickListener {
            optionAlertDialog.show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Intent(this, Page4Activity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
            finish()
        }
    }
}