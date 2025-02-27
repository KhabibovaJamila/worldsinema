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
        replaceFragment(HomeFragment())
        binding.bottomNavigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.main -> replaceFragment(HomeFragment())

                R.id.selection -> replaceFragment(SelectionFragment())
                R.id.collection -> replaceFragment(CollectionFragment())
                R.id.profile-> replaceFragment(ProfileFragment())

                else->{

                }
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }

}