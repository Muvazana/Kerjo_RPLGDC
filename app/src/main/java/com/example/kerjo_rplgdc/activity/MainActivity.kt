package com.example.kerjo_rplgdc.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kerjo_rplgdc.R
import com.example.kerjo_rplgdc.fragment.HistoryFragment
import com.example.kerjo_rplgdc.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadHomeFragment()
                }
                R.id.history -> {
                    loadHistoryFragment()
                }
            }
            true
        }

        if (savedInstanceState == null) {
            bottom_navigation.selectedItemId = R.id.home
        }
    }

    private fun loadHomeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_layout, HomeFragment(), HomeFragment::class.java.simpleName)
            .commit()
    }

    private fun loadHistoryFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_layout, HistoryFragment(), HistoryFragment::class.java.simpleName)
            .commit()
    }
}
