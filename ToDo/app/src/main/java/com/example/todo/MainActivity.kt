package com.example.todo

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var todoList = mutableListOf(Todo("Are you learn RecyclerView?", false))
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
        val adapter = TodoAdapter(todoList)
        b.rvMain.adapter = adapter
        b.rvMain.layoutManager = LinearLayoutManager(this)

        b.btnAdd.setOnClickListener {
            val title = b.edTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)

            val x = getSystemService(INPUT_METHOD_SERVICE)as InputMethodManager
            x.hideSoftInputFromWindow(b.edTodo.windowToken,0)
            b.edTodo.text.clear()
        }
    }
}