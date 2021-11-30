package com.mdapp.listadapter.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mdapp.listadapter.R
import com.mdapp.listadapter.model.Language

class LanguagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(item: Language) {
        itemView.findViewById<TextView>(R.id.languageName).text = item.name
        itemView.findViewById<TextView>(R.id.languageDescription).text = item.name
    }
}