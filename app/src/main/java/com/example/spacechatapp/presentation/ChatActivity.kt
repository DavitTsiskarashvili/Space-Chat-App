package com.example.spacechatapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.spacechatapp.R
import com.example.spacechatapp.databinding.ActivityMainBinding
import com.example.spacechatapp.presentation.chat_screen.ui.ChatFragment

class ChatActivity : AppCompatActivity() {

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
            add(R.id.topFragment, ChatFragment())
            add(R.id.bottomFragment, ChatFragment())
        }.commit()
    }


    private fun changeDayNightModes() {
        binding.swDayNight.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked){
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }
            )
        }
    }

}