package com.example.activityrecyclerviewfragment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import kotlinx.android.synthetic.main.activity_email.*

class EmailActivity : AppCompatActivity() {
    var numberWait : Int = 30
    private val handlerThread: HandlerThread = HandlerThread("wait")
    private lateinit var handler: Handler
    private lateinit var waitNumber: Runnable

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        handlerThread.start()
        handler = Handler(handlerThread.looper)

        waitNumber = Runnable {
            when {
                numberWait > 0 -> {
                    numberWait--
                    this.runOnUiThread {
                        wait.text = "Wait $numberWait seconds before sending !"
                    }
                    handler.postDelayed(waitNumber, 1000)
                }
                numberWait == 0 -> {
                    this.runOnUiThread {
                        wait.text = "Sending!"
                    }
                }
            }
        }
        handler.postDelayed(waitNumber,1000)
        resendEmail.setOnClickListener {
            if (numberWait == 0) {
                val intent = Intent(this, ConfirmChangePasswordActivity::class.java)
                startActivity(intent)
            }
        }

    }
}