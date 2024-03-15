package com.example.h_beta_users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.h_beta_users.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    lateinit var loginButton: Button
    lateinit var regButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getWidget()
        regClick(); logClick()

    }

    private fun getWidget(){
        loginButton = this.findViewById(R.id.HLogin_button)
        regButton = this.findViewById(R.id.HReg_button)
    }
    private fun regClick(){
        regButton.setOnClickListener(){
            Toast.makeText(applicationContext, "Sign Up Clicked", LENGTH_SHORT).show()
            // start your activity by passing the intent
            startActivity(Intent(this, RegActivity::class.java).apply {
                // you can add values(if any) to pass to the next class or avoid using `.apply`
//                putExtra("keyIdentifier", value)
            })
        }

    }
    private fun logClick(){
        loginButton.setOnClickListener(){
            val toast = Toast.makeText(applicationContext, "Login Clicked", LENGTH_SHORT)
            val handler = Handler(Looper.getMainLooper())
           val runnable= Runnable {
               toast.show()
               startActivity(Intent(this, LoginActivity::class.java))
               //to repeat:  handler.postDelayed(this,2000)
           }
            handler.postDelayed(runnable,1000)

        }
    }

//    val handler = Handler()
//    val runnable = object : Runnable {
//        override fun run () {
//            handler.postDelayed(this,2000)
//        }
//    }


//    val handler = Handler()
//    val runnable = object : Runnable {
//        override fun run () {
//            handler.removeCallbacksAndMessages(null)
//            //make sure you cancel the
//            previous task in case you scheduled one that has not run yet
//                    //do your thing
//
//                    handler.postDelayed(runnable,time)
//        }
//    }

}