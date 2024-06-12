package com.example.todo

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}