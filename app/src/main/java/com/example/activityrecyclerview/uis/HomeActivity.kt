package com.example.activityrecyclerview.uis

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import java.util.*

@Suppress("UNREACHABLE_CODE", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HomeActivity : AppCompatActivity(){
    private val home = HomeFragment()
    private val coin = CoinFragment()
    private val news = NewsFragment()
    private val customer = CustomerFragment()

    private var count = 1
    private var flag : Boolean = true
    private var integerDeque : Deque<Int> = ArrayDeque()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        integerDeque.push(R.id.home)
        loadFragments(home)

        bottomNavigation.selectedItemId = R.id.home
        bottomNavigation.setOnNavigationItemSelectedListener {
            val id : Int = it.itemId
            if (integerDeque.contains(id)) {
                if (id == R.id.home) {
                    if (integerDeque.size !=1) {
                        if (flag) {
                            integerDeque.addFirst(R.id.home)
                            flag = false
                            Log.d("fragment", flag.toString())
                        }
                    }
                }
                integerDeque.remove(id)
            }
            integerDeque.push(id)
            Log.d("fragment", integerDeque.toString())
            loadFragments(getFragment(it.itemId))
            true
        }

        val layout : CoordinatorLayout.LayoutParams = bottomNavigation.layoutParams as CoordinatorLayout.LayoutParams
        layout.behavior = BottomNavigationBehavior()
    }

    private fun getFragment(itemId: Int): Fragment {
        when(itemId) {
            R.id.home -> {
                bottomNavigation.menu.getItem(0).isChecked = true
                return home
            }
            R.id.coin -> {
                bottomNavigation.menu.getItem(1).isChecked = true
                return coin
            }
            R.id.news -> {
                bottomNavigation.menu.getItem(2).isChecked = true
                return news
            }
            else -> {
                bottomNavigation.menu.getItem(3).isChecked = true
                return customer
            }
        }
        bottomNavigation.menu.getItem(0).isChecked = true
        return home

    }

    private fun loadFragments(fragment: Fragment) {
        bottomNavigation.itemIconTintList =
            ContextCompat.getColorStateList(this, R.color.bottom_navigation_color)
        bottomNavigation.itemBackground =
            ContextCompat.getDrawable(this, R.drawable.background_bottom)
        Log.d("fragment", count.toString())
        count++
        supportFragmentManager.beginTransaction().replace(R.id.fragmentMain,fragment).addToBackStack("Fragment").commit()
        //return true
    }

    override fun onBackPressed() {
        integerDeque.pop()
        if (!integerDeque.isEmpty()) {
            Log.d("fragment", integerDeque.toString())
            loadFragments(getFragment(integerDeque.peek()))
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("????ng xu???t")
            builder.setMessage("B???n c?? mu???n k???t th??c phi??n ????ng nh???p n??y?")
            builder.setPositiveButton("Yes"){ _, _ ->
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("No"){ _, _ ->
                integerDeque.addFirst(R.id.home)
                loadFragments(getFragment(R.id.home))
                //flag = true
            }
            builder.show()
        }
    }

}