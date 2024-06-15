package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RvAdapter(private val list: List<Data>) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    private var lastClickedPosition: Int? = null
    inner class RvViewHolder(view: View) : ViewHolder(view){
        val textTitle:TextView = view.findViewById(R.id.txtRvTitle)
        val textDetail:TextView = view.findViewById(R.id.txtRvDetail)
        val r: ImageButton = view.findViewById(R.id.iBtn1)
        val g: ImageButton = view.findViewById(R.id.iBtn2)
        val b: ImageButton = view.findViewById(R.id.iBtn3)
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

        holder.r.visibility = View.GONE
        holder.g.visibility = View.GONE
        holder.b.visibility = View.GONE

        if (lastClickedPosition == position) {
            holder.r.visibility = View.VISIBLE
            holder.g.visibility = View.VISIBLE
            holder.b.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener {
            if (lastClickedPosition == holder.adapterPosition) {
                lastClickedPosition = null
                notifyItemChanged(holder.adapterPosition)
            } else {
                val previousPosition = lastClickedPosition
                lastClickedPosition = holder.adapterPosition
                previousPosition?.let { notifyItemChanged(it) }
                notifyItemChanged(holder.adapterPosition)
            }
        }
        holder.r.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "You clicked ${item.name}'s Red",
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.g.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "You clicked ${item.name}'s Green",
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.b.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "You clicked ${item.name}'s Blue",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}