package com.example.world_sinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.world_sinema.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


private val SplashScreen:Long = 2500

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        lateinit var auth: FirebaseAuth
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            startActivity(Intent(this,StartActivity::class.java))
            finish()
        }, SplashScreen)
        auth = FirebaseAuth.getInstance()


    }

}