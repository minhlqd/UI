package com.example.activityrecyclerviewfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_on_boarding_2.*
import kotlinx.android.synthetic.main.activity_on_boarding_2.back
import kotlinx.android.synthetic.main.activity_on_boarding_2.skip
import kotlinx.android.synthetic.main.activity_on_boarding_3.*

class OnBoarding2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_2)

        next.setOnClickListener {
            val intent = Intent(this, OnBoarding3Activity::class.java)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this, OnBoarding1Activity::class.java)
            startActivity(intent)
        }

        skip.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}