package com.example.kfc_sample_client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class profileRecyclerAdapter(private val userList: List<CollectedItemsFromDB>):RecyclerView.Adapter<ItemViewHolderUserDetails>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolderUserDetails {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolderUserDetails(itemView)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ItemViewHolderUserDetails, position: Int) {
        holder.bind(userList[position])
    }
}