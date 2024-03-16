package com.example.kfc_sample_client

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        navigationView = findViewById(R.id.main_navigation)
        navigationView.setOnItemSelectedListener{ item -> val selectedFragment: Fragment? = when (item.itemId) {
            R.id.navigation_home -> homePage()
            R.id.navigation_order -> orders_page()
            R.id.navigation_profile -> profile_page()
            else -> null
        }
        if (selectedFragment != null){
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_fragment_container,selectedFragment)
            transaction.commit()
        }
            true
        }
    }

}

