package com.example.kfc_sample_client

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolderUserDetails(itemView: View) :RecyclerView.ViewHolder(itemView) {
    val headerTextView: TextView = itemView.findViewById(R.id.list_item_heading)
    val contentTextView: TextView = itemView.findViewById(R.id.list_item_content)

    fun bind(item:CollectedItemsFromDB){
        headerTextView.text = "Name"
        contentTextView.text = item.thisUserName.toString()
    }

}