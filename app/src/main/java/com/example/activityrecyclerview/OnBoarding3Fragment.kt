package com.example.activityrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_on_boarding3.*

class OnBoarding3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController : NavController = Navigation.findNavController(view)
        start.setOnClickListener {
            navController.navigate(R.id.action_onBoarding3Fragment_to_loginActivity)
        }
        skip.setOnClickListener {
            navController.navigate(R.id.action_onBoarding3Fragment_to_loginActivity)
        }
        back.setOnClickListener {
            navController.navigate(R.id.action_onBoarding3Fragment_to_onBoarding2Fragment)
        }
    }

}