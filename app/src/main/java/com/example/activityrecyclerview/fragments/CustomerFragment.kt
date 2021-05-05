package com.example.activityrecyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.adaters.CustomerAdapter
import com.example.activityrecyclerview.data.Customer
import com.example.activityrecyclerview.data.New
import kotlinx.android.synthetic.main.fragment_customer.*

class CustomerFragment : Fragment() {

    lateinit var customer1: MutableList<Customer>
    lateinit var customer2: MutableList<Customer>
    lateinit var customer3: MutableList<Customer>
    lateinit var customer4: MutableList<Customer>
    lateinit var customerAdapter: CustomerAdapter
    lateinit var layoutManager: LinearLayoutManager

    val name = Customer("Alerts",21)
    private val name2 = Customer("Select Stocks",21)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customer1 = mutableListOf()
        customer2 = mutableListOf()
        customer3 = mutableListOf()
        customer4 = mutableListOf()
        customerAdapter = CustomerAdapter(customer1,customer2,customer4)
        recycleView.setHasFixedSize(false)
        layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager
        recycleView.adapter = customerAdapter

        for (i in 0..3) {
            val drawable = when (i%4) {
                0 -> R.drawable.icons_8_profit
                1 -> R.drawable.icons_8_swap
                2 -> R.drawable.icons_8_video_call
                else -> R.drawable.icons_8_rent
            }
            val name = when (i%4) {
                0 -> "Select Stocks"
                1 -> "Currency Exchange"
                2 -> "Webinar"
                else -> "Best Broker"
            }
            val item = Customer(name, drawable)
            customer2.add(item)
        }
        customerAdapter.notifyDataSetChanged()
        customer4.add(Customer("Tools", 2))
        customerAdapter.notifyDataSetChanged()
        for (i in 0..3) {
            val drawable = when (i%4) {
                0 -> R.drawable.icons_8_alarm
                1 -> R.drawable.icons_8_left_and_right_arrows
                2 -> R.drawable.icons_8_pin
                else -> R.drawable.icons_8_no_entry
            }
            val name = when (i%4) {
                0 -> "Alerts"
                1 -> "Predictions"
                2 -> "Saved elements"
                else -> "Remove Ads"
            }
            val item = Customer(name, drawable)
            customer1.add(item)
        }

        back.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentMain, NewsFragment())?.commit()
        }

    }

}
