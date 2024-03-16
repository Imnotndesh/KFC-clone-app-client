package com.example.kfc_sample_client

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
class homePage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =inflater.inflate(R.layout.fragment_home_page, container, false)

    private lateinit var parentActivity: Activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = context as Activity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button:Button = view.findViewById(R.id.menu_quick_links)
        button.setOnClickListener{
            val fragmentManager = parentFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container,menu_fragment())
            transaction.commit()
        }
    }
    }