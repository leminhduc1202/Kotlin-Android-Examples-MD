package com.mdapp.listadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mdapp.listadapter.R
import com.mdapp.listadapter.model.Language

class LanguageAdapter: ListAdapter<Language, LanguagesViewHolder>(LanguageDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguagesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.language_list, parent, false)
        return LanguagesViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguagesViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }
}