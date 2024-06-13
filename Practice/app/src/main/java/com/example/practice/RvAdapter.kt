package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RvAdapter(val list: List<Data>) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    inner class RvViewHolder(view: View) : ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout, parent, false)
        return RvViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.txtRvTitle).text = list[position].name
            findViewById<TextView>(R.id.txtRvNumber).text = list[position].number
        }
    }
}