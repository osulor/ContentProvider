package com.example.displayguests.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.displayguests.R
import kotlinx.android.synthetic.main.guest_item_view.view.*

class GuestAdapter(private var guestList: List<String>): RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.guest_item_view,parent,false)

        return GuestViewHolder(view)

    }

    override fun getItemCount(): Int {
        return guestList.size
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.apply {

            name.text = guestList[position]
        }
    }


    inner class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name = itemView.findViewById<TextView>(R.id.name_textView)
    }
}