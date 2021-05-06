package com.example.activityrecyclerview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.activityrecyclerview.R
import com.example.activityrecyclerview.adaters.CustomerAdapter
import com.example.activityrecyclerview.data.Customer
import kotlinx.android.synthetic.main.fragment_customer.*

class CustomerFragment : Fragment() {

    private lateinit var customer1: MutableList<Customer>
    private lateinit var customer2: MutableList<Customer>
    private lateinit var customer3: MutableList<Customer>
    private lateinit var customer4: MutableList<Customer>
    private lateinit var customer5: MutableList<Customer>
    private lateinit var customerAdapter: CustomerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customer1 = mutableListOf()
        getDataCustomer1()
        customer2 = mutableListOf()
        getDataCustomer2(customer2)

        customer3 = mutableListOf()
        customer3.add(Customer("Tools", 1))

        customer4 = mutableListOf()
        customer4.add(Customer("Markets", 1))

        customer5 = mutableListOf()
        getDataCustomer2(customer5)

        customerAdapter = CustomerAdapter(customer1,customer2,customer3,customer4,customer5)
        recycleView.setHasFixedSize(false)
        layoutManager = LinearLayoutManager(context)
        recycleView.layoutManager = layoutManager
        recycleView.adapter = customerAdapter

        back.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentMain, NewsFragment())?.commit()
        }
    }
    private fun getDataCustomer1() {
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
    }
    private fun getDataCustomer2(list: MutableList<Customer>) {
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
            list.add(item)
        }
    }


}
