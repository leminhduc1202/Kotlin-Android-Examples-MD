package com.mdapp.diffutil

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.logging.Logger

class ContactsAdapter(
    private val context: Context,
    private val personList: MutableList<Person>
) : RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {

    companion object {
        val log = Logger.getLogger("ContactsAdapter")
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(person: Person) {
            itemView.findViewById<TextView>(R.id.name_text_view).text = person.name
            itemView.findViewById<TextView>(R.id.status_text_view).text = person.status
        }

    }

    fun updateData(newList: List<Person>) {
        val diffResult = DiffUtil.calculateDiff(ContactDiffUtilCallBack(newList, personList))
        diffResult.dispatchUpdatesTo(this)
        this.personList.clear()
        this.personList.addAll(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val bundle = payloads[0] as Bundle
            for (key in bundle.keySet()) {
                if (key == "name") {
                    holder.itemView.findViewById<TextView>(R.id.name_text_view).text =
                        personList[position].name
                }
                if (key == "status") {
                    log.info("Change are ready to show")
                    holder.itemView.findViewById<TextView>(R.id.status_text_view).text =
                        personList[position].status
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(personList[position])
    }
}