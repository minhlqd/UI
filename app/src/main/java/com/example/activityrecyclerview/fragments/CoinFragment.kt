package com.example.activityrecyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.activityrecyclerview.R
import kotlinx.android.synthetic.main.fragment_coin.*

class CoinFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alarm.setOnClickListener {
            Toast.makeText(context, "alarm", Toast.LENGTH_SHORT).show()
        }
        val navController : NavController = Navigation.findNavController(view)
        bottom_navigation.itemIconTintList = null
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> navController.navigate(R.id.action_coinFragment_to_homeFragment)
                R.id.news -> navController.navigate(R.id.action_coinFragment_to_newsFragment)
                else -> navController.navigate(R.id.action_coinFragment_to_customerFragment)
            }
            true
        }
    }

}