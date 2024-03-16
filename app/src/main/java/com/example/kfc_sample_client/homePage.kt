package com.example.kfc_sample_client

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
class homePage : Fragment() {
    data class NotificationItem(val title: String, val message: String)
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

        // Quick links buttons
        val button:Button = view.findViewById(R.id.menu_quick_links)
        val locationsButton :Button = view.findViewById(R.id.locations_quick_links)
        val servicesQuickLink:Button = view.findViewById(R.id.services_quick_link)
        val ordersQuickLink:Button = view.findViewById(R.id.orders_quick_link)


        // Onclick handlers for Quick links
        servicesQuickLink.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container,services_page())
            transaction.commit()
        }
        locationsButton.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container,locations_page())
            transaction.commit()
        }
        button.setOnClickListener{
            val fragmentManager = parentFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container,menu_fragment())
            transaction.commit()
        }
        ordersQuickLink.setOnClickListener {
            val fragmentManager = parentFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container,previous_orders())
            transaction.commit()
        }
        // top notifications
        val top_notifications = view.findViewById<TextView>(R.id.notification_text_top)
        val notificationList = listOf(
            NotificationItem("Notification1","Offer for Beef steaks still valid!"),
            NotificationItem("Notification1","Offer for Beef chops still valid!")
        )
        top_notifications.setOnClickListener {
            showNotificationsList(notificationList)
        }
    }
    private fun showNotificationsList(notificationList: List<NotificationItem>) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Notifications")
        val notificationItems = notificationList.joinToString("\n-"){it.message}
        builder.setMessage(notificationItems)
        builder.setPositiveButton("close"){
            dialog, _ -> dialog.dismiss()
        }
        builder.create().show()
    }
}