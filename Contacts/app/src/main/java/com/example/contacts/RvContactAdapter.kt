package com.example.contacts

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RvContactAdapter(private val list: List<ContactData>) :
    RecyclerView.Adapter<RvContactAdapter.RvContactViewHolder>() {

    private var lastClickedPosition: Int? = null

    inner class RvContactViewHolder(view: View) : ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.txtRvName)
        val number: TextView = view.findViewById(R.id.txtRvNumber)
        val profilePhoto: ImageView = view.findViewById(R.id.ivRvProfilePhoto)
        val call: ImageView = view.findViewById(R.id.ivRvCall)
        val message: ImageView = view.findViewById(R.id.ivRvMessage)
        val history: ImageView = view.findViewById(R.id.ivRvHistory)
        val cardView: CardView = view.findViewById(R.id.cvRvMain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_contact_item, parent, false)
        return RvContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvContactViewHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.number.text = item.number
        holder.profilePhoto.setImageResource(item.profilePhoto)

        holder.call.visibility = View.GONE
        holder.message.visibility = View.GONE
        holder.history.visibility = View.GONE
        holder.cardView.setCardBackgroundColor(Color.parseColor("#EFEFEF"))

        if (lastClickedPosition == holder.adapterPosition) {
            holder.call.visibility = View.VISIBLE
            holder.message.visibility = View.VISIBLE
            holder.history.visibility = View.VISIBLE
            holder.cardView.setCardBackgroundColor(Color.parseColor("#ACACAC"))
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

        holder.call.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Calling ${list[position].name}, But\nCalling Feature not added yet😥",
                Toast.LENGTH_LONG
            ).show()
        }
        holder.message.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Open Message app for ${list[position].name}, But\nOpen Message app Feature not added yet😥",
                Toast.LENGTH_LONG
            ).show()
        }
        holder.history.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Opening ${list[position].name}'s history, But\nHistory Feature not added yet😥",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}