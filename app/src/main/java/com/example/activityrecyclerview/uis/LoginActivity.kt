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
        var intent: Intent = this.intent
        val changePassword : String? = intent.getStringExtra("password")
        login.setOnClickListener {
            val txtEmail = email.text.toString()
            val txtPassword = password.text.toString()
            Log.d("aaa", (txtEmail == adminEmail).toString())
            Log.d("aaa", (txtPassword == adminPassword).toString())
            if (changePassword != null && adminEmail == txtEmail && changePassword == txtPassword) {
                val intentHome = Intent(this, HomeActivity::class.java)
                startActivity(intentHome)
            } else if (changePassword == null && adminEmail == txtEmail && adminPassword == txtPassword) {
                val intentHome = Intent(this, HomeActivity::class.java)
                startActivity(intentHome)
            } else {
                email.error = "Email or password incorrect"
            }
        }
        signup.setOnClickListener {
            val intentSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(intentSignUp)
        }
        forgotPassword.setOnClickListener {
            val intentPassword = Intent(this, EmailActivity::class.java)
            startActivity(intentPassword)
        }
    }
}