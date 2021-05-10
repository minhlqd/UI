package com.example.activityrecyclerview.uis

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.fragments.CoinFragment
import com.example.activityrecyclerview.fragments.CustomerFragment
import com.example.activityrecyclerview.fragments.HomeFragment
import com.example.activityrecyclerview.fragments.NewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_coin.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val home = HomeFragment()
    private val coin = CoinFragment()
    private val news = NewsFragment()
    private val customer = CustomerFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadFragments(home)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragments(fragment: Fragment) : Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentMain,fragment).addToBackStack("Fragment").commit()
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                bottom_navigation.itemIconTintList =
                    ContextCompat.getColorStateList(this, R.color.bottom_navigation_color)
                bottom_navigation.itemBackground =
                    ContextCompat.getDrawable(this, R.drawable.background_bottom)
            }
            R.id.coin -> {
                bottom_navigation.itemIconTintList =
                    ContextCompat.getColorStateList(this, R.color.bottom_navigation_color)
                bottom_navigation.itemBackground =
                    ContextCompat.getDrawable(this, R.drawable.background_bottom)
            }
            R.id.news -> {
                bottom_navigation.itemIconTintList =
                    ContextCompat.getColorStateList(this, R.color.bottom_navigation_color)
                bottom_navigation.itemBackground =
                    ContextCompat.getDrawable(this, R.drawable.background_bottom)
            }
            R.id.customer -> {
                bottom_navigation.itemIconTintList =
                    ContextCompat.getColorStateList(this, R.color.bottom_navigation_color)
                bottom_navigation.itemBackground =
                    ContextCompat.getDrawable(this, R.drawable.background_bottom)
            }
        }
        var fragment: Fragment? = null
        fragment = when (item.itemId) {
            R.id.home -> home
            R.id.coin -> coin
            R.id.news -> news
            else -> customer
        }
        return loadFragments(fragment)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1 ){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Đăng xuất")
            builder.setMessage("Bạn có muốn kết thúc phiên đăng nhập này?")
            builder.setPositiveButton("Yes"){ _, _ ->
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("No"){ _, _ ->
                loadFragments(home)
            }
            builder.show()
        } else {
            super.onBackPressed()
        }
    }
}