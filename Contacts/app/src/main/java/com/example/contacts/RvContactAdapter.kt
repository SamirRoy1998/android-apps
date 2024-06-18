package com.example.contacts

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.contacts.databinding.RvContactItemBinding

class RvContactAdapter(private val list: List<ContactData>) :
    RecyclerView.Adapter<RvContactAdapter.RvContactViewHolder>() {

    private var lastClickedPosition: Int? = null

    inner class RvContactViewHolder(val b: RvContactItemBinding) : ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvContactViewHolder {
        val binding =
            RvContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RvContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvContactViewHolder, position: Int) {
        val item = list[position]
        holder.b.txtRvName.text = item.name
        holder.b.txtRvNumber.text = item.number
        holder.b.ivRvProfilePhoto.setImageResource(item.profilePhoto)

        holder.b.ivRvCall.visibility = View.GONE
        holder.b.ivRvMessage.visibility = View.GONE
        holder.b.ivRvHistory.visibility = View.GONE
        holder.b.cvRvMain.setCardBackgroundColor(Color.parseColor("#EFEFEF"))

        if (lastClickedPosition == holder.adapterPosition) {
            holder.b.ivRvCall.visibility = View.VISIBLE
            holder.b.ivRvMessage.visibility = View.VISIBLE
            holder.b.ivRvHistory.visibility = View.VISIBLE
            holder.b.cvRvMain.setCardBackgroundColor(Color.parseColor("#ACACAC"))
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

        holder.b.ivRvCall.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Calling ${list[position].name}, But\nCalling Feature not added yet😥",
                Toast.LENGTH_LONG
            ).show()
        }
        holder.b.ivRvMessage.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Open Message app for ${list[position].name}, But\nOpen Message app Feature not added yet😥",
                Toast.LENGTH_LONG
            ).show()
        }
        holder.b.ivRvHistory.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Opening ${list[position].name}'s history, But\nHistory Feature not added yet😥",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}