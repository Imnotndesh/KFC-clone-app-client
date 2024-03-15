package com.example.kfc_sample_client

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
class CustomListAdapter(private val context: Context ) : BaseAdapter(){
    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder : CustomListAdapter.ViewHolder
        if (convertView == null){
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(
                R.layout.list_item,
                null
            )
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            println("sumn")
        }
        return convertView!!
    }
    private class ViewHolder(view: View){
        val textView: TextView = view.findViewById(R.id.list_item_heading)
    }
}