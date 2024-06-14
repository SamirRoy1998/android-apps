package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RvAdapter(val list: List<Data>) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    inner class RvViewHolder(view: View) : ViewHolder(view){
        val textTitle:TextView = view.findViewById(R.id.txtRvTitle)
        val textDetail:TextView = view.findViewById(R.id.txtRvDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_layout, parent, false)
        return RvViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val item = list[position]
        holder.textTitle.text = item.name
        holder.textDetail.text = item.number
    }
}