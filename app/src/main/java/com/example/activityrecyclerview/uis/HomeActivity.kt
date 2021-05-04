package com.example.activityrecyclerview.uis

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.fragments.CoinFragment
import com.example.activityrecyclerview.fragments.CustomerFragment
import com.example.activityrecyclerview.fragments.HomeFragment
import com.example.activityrecyclerview.fragments.NewsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

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
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0 ){
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
        }
    }
}