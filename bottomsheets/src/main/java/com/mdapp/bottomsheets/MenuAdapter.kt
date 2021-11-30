package com.mdapp.bottomsheets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val context: Context, private val listImage: List<Int>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    class MenuViewHolder (itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindItems(image : Int){
            itemView.findViewById<ImageView>(R.id.image_card_view).setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_recycler_view, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindItems(listImage[position])
    }

    override fun getItemCount(): Int {
        return 4
    }
}