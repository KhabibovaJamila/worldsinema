package com.example.world_sinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import com.example.world_sinema.databinding.ActivityStartBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){

            }
            true
        }

    }

}