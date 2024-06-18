package com.example.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager.databinding.ViewPagerItemBinding

class ViewPagerAdapter(private val list: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.VpViewHolder>() {
    inner class VpViewHolder(val b: ViewPagerItemBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VpViewHolder {
        val b = ViewPagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VpViewHolder(b)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VpViewHolder, position: Int) {
        val item = list[position]
        holder.b.ivImage.setImageResource(item)
    }
}