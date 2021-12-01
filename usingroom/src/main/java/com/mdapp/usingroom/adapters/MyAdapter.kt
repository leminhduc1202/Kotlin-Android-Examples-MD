package com.mdapp.usingroom.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mdapp.usingroom.R
import com.mdapp.usingroom.SuperHero

class MyAdapter(
    val context: Context,
    val superHeroList: List<SuperHero>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(superHero: SuperHero) {
            itemView.findViewById<TextView>(R.id.superHeroName).text =
                "Name: ${superHero.SuperheroName}"
            itemView.findViewById<TextView>(R.id.superHeroPower).text =
                "Power: ${superHero.Power}"
            itemView.findViewById<TextView>(R.id.superHeroSeries).text =
                "Series: ${superHero.SuperHeroSeries}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.list_row_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(superHeroList[position])
    }

    override fun getItemCount(): Int {
        return superHeroList.size
    }

}