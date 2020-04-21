package com.example.ashoka.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ashoka.R
import com.example.ashoka.objects.wtg

class wtg_adapter(val context: Context) : RecyclerView.Adapter<wtg_adapter.wtg_viewHolder>() {

    var wtg_list: List<wtg> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): wtg_viewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.list_what_to_grow, parent, false)
        return wtg_viewHolder(v)

    }

    override fun getItemCount(): Int {
        return wtg_list.size

    }

    override fun onBindViewHolder(holder: wtg_viewHolder, position: Int) {
        holder.wtg_head.text = wtg_list[position].title
        holder.wtg_desc.text = wtg_list[position].desc
        Glide.with(context).load(wtg_list[position].url)
            .into(holder.wtg_img)
    }

    fun setItems(data: List<wtg>) {
        this.wtg_list = data
        notifyDataSetChanged()
    }

    class wtg_viewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val wtg_head = itemView!!.findViewById<TextView>(R.id.wtg_head)
        val wtg_desc = itemView!!.findViewById<TextView>(R.id.desc_what_to_grow)
        val wtg_img = itemView!!.findViewById<ImageView>(R.id.wtg_img)

    }

}









