package com.example.kfc_sample_client

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CustomListAdapter(private val context: Context ) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder : ViewHolder
        if (convertView == null){
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            pass
        }
        return convertView!!
    }
    private class ViewHolder(view: View){
        val textView: TextView = view.findViewById(R.id.list_item_heading)
    }
}