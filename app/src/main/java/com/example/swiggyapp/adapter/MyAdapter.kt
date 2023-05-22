package com.example.swiggyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.swiggyapp.R
import com.example.swiggyapp.response.productResponseItem

class MyAdapter(var con: Context, var list: List<productResponseItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var img= itemView.findViewById<ImageView>(R.id.profile_image)
        var tvName = itemView.findViewById<TextView>(R.id.tv_Name)
        var tvPrice = itemView.findViewById<TextView>(R.id.tv_Price)
        var tvDesc = itemView.findViewById<TextView>(R.id.tv_Rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view= LayoutInflater.from(con).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(con).load(list[position].imageUrl).into(holder.img)
        holder.tvName.text=list[position].name
        holder.tvPrice.text= list[position].price.toString()
        holder.tvDesc.text=list[position].rating



    }

    override fun getItemCount(): Int {
        return list.size
    }



}