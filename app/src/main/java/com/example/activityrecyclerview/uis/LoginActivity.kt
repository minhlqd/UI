package com.example.activityrecyclerview.uis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activityrecyclerview.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val adminEmail : String = "mtlab@gmail.com"
    private val adminPassword : String = "1234"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener {
            val txtEmail = email.text.toString()
            val txtPassword = password.text.toString()
            Log.d("aaa", (txtEmail == adminEmail).toString())
            Log.d("aaa", (txtPassword == adminPassword).toString())
            Log.d("aaa", txtPassword)
            if (adminEmail == txtEmail && adminPassword == txtPassword) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                email.error = "Email or password incorrect"
            }
        }
        signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        forgotPassword.setOnClickListener {
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }
    }
}