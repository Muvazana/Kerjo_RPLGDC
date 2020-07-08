package com.example.kerjo_rplgdc.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kerjo_rplgdc.R
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
}
