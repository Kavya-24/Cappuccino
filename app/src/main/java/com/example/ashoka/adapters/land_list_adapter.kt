package com.example.ashoka.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ashoka.R
import com.example.ashoka.data.Land_farmer
import com.example.ashoka.models.farmer_land
import com.example.ashoka.ui.myLands.MyLandsViewModel

//Add the data list
//class land_list_adapter(val land_list: ArrayList<Land_farmer>) :
//    RecyclerView.Adapter<land_list_adapter.ViewHolder>() {
class land_list_adapter(private var item: ArrayList<farmer_land>) :
    RecyclerView.Adapter<land_list_adapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_name = itemView.findViewById<TextView>(R.id.land_name).toString()
        var tv_location = itemView.findViewById<TextView>(R.id.land_profit).toString()
        var tv_profits = itemView.findViewById<TextView>(R.id.land_location).toString()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Here we will attach the views to the Kotlin Class
        val v = LayoutInflater.from(parent.context).inflate(R.layout.my_lands_list, parent, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        //Returns the size of  the data that we retrieve
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Bind the views in this method
        val fl : farmer_land = item[position]
        holder.tv_name = fl.name
        holder.tv_location = fl.location
        holder.tv_profits = fl.profits


    }


}