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
        val signUpEmail : String? = intent.getStringExtra("email")
        val signUpPassword : String? = intent.getStringExtra("signUp password")
        this.email.setText(signUpEmail)
        this.password.setText(signUpPassword)
        Log.d("aaa", signUpPassword.toString())
        login.setOnClickListener {
//            startActivity(Intent(this, HomeActivity::class.java))
            val txtEmail = email.text.toString()
            val txtPassword = password.text.toString()
            if (txtEmail != "" && txtPassword != "" && txtEmail == signUpEmail && txtPassword == signUpPassword) {
                startActivity(Intent(this, HomeActivity::class.java))
            } else if (changePassword != null && adminEmail == txtEmail && changePassword == txtPassword) {
                    startActivity(Intent(this, HomeActivity::class.java))
            } else if (changePassword == null && adminEmail == txtEmail && adminPassword == txtPassword) {
                startActivity(Intent(this, HomeActivity::class.java))
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