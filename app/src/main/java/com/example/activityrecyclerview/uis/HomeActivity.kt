package com.example.activityrecyclerview.uis

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.activityrecyclerview.BottomNavigationBehavior
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.fragments.CoinFragment
import com.example.activityrecyclerview.fragments.CustomerFragment
import com.example.activityrecyclerview.fragments.HomeFragment
import com.example.activityrecyclerview.fragments.NewsFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(){
    private val home = HomeFragment()
    private val coin = CoinFragment()
    private val news = NewsFragment()
    private val customer = CustomerFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadFragments(home)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> loadFragments(home)
                R.id.coin -> loadFragments(coin)
                R.id.news -> loadFragments(news)
                else -> loadFragments(customer)
            }
            true
        }
        val layout : CoordinatorLayout.LayoutParams = bottomNavigation.layoutParams as CoordinatorLayout.LayoutParams
        layout.behavior = BottomNavigationBehavior()
    }

    private fun loadFragments(fragment: Fragment) : Boolean {
        bottomNavigation.itemIconTintList =
            ContextCompat.getColorStateList(this, R.color.bottom_navigation_color)
        bottomNavigation.itemBackground =
            ContextCompat.getDrawable(this, R.drawable.background_bottom)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentMain,fragment).addToBackStack("Fragment").commit()
        return true
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