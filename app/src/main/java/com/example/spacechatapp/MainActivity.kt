package com.example.spacechatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.spacechatapp.databinding.ActivityMainBinding
import com.example.spacechatapp.presentation.ui.topFragment.TopFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentSetup()
        changeDayNightModes()
    }


    private fun fragmentSetup() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.topFragment, TopFragment())
            add(R.id.bottomFragment, BottomFragment())
        }.commit()
    }


    private fun changeDayNightModes() {
        binding.swDayNight.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

}



