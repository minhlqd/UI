package com.example.activityrecyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.activityrecyclerview.R
import kotlinx.android.synthetic.main.fragment_customer.*

class CustomerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController: NavController = Navigation.findNavController(view)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> navController.navigate(R.id.action_customerFragment_to_homeFragment)
                R.id.coin -> navController.navigate(R.id.action_customerFragment_to_coinFragment)
                else -> navController.navigate(R.id.action_customerFragment_to_newsFragment)
            }
            true
        }
    }

}
