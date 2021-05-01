package com.example.activityrecyclerview.uis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.fragments.CoinFragment
import com.example.activityrecyclerview.fragments.CustomerFragment
import com.example.activityrecyclerview.fragments.HomeFragment
import com.example.activityrecyclerview.fragments.NewsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private val home = HomeFragment()
    private val coin = CoinFragment()
    private val news = NewsFragment()
    private val customer = CustomerFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(home)
                R.id.coin -> replaceFragment(coin)
                R.id.news -> replaceFragment(news)
                else -> replaceFragment(customer)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_main, fragment)
            transaction.commit()
        }
    }
}