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
        return inflater.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        alarm.setOnClickListener {
            Toast.makeText(context, "alarm", Toast.LENGTH_SHORT).show()
        }
        back.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragmentMain, HomeFragment())?.commit()
        }
    }

}