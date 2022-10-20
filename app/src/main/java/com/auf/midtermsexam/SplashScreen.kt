package com.auf.midtermsexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.auf.midtermsexam.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
        val username = sharedPreferences.getString(USERNAME, "").toString()
        supportActionBar?.hide()

        if(username == ""){
            binding.welcometxt.text = "Welcome to my \n Application"
        }
        else{
            binding.welcometxt.text = "Welcome to my \n Application\n$username";
        }

        object : CountDownTimer(5000, 1000){
            override fun onTick(p0: Long) {

            }
            override fun onFinish() {
                val intent = Intent(this@SplashScreen,MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }.start()
    }
}