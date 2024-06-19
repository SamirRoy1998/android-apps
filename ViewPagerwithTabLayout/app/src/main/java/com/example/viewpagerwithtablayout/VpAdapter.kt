package com.example.viewpagerwithtablayout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerwithtablayout.databinding.ViewpagerItemsBinding

class VpAdapter(private val list: List<Int>) : RecyclerView.Adapter<VpAdapter.VpViewHolder>() {
    inner class VpViewHolder(val binding: ViewpagerItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VpViewHolder {
        val bindingView =
            ViewpagerItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VpViewHolder(bindingView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VpViewHolder, position: Int) {
        val image = list[position]
        holder.binding.ivVpImage.setImageResource(image)
    }
}