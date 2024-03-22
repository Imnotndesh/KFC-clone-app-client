package com.example.kfc_sample_client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView

class profile_page : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_profile_page, container, false)
    public lateinit var addsampledata :Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addsampledata = view.findViewById(R.id.addSampleData)
        addsampledata.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container,add_data_page())
            transaction.commit()
        }
    }

}