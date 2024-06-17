package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private val list: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.VpViewHolder>() {
    inner class VpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VpViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false)
        return VpViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VpViewHolder, position: Int) {
        val item = list[position]
        holder.image.setImageResource(item)
    }
}