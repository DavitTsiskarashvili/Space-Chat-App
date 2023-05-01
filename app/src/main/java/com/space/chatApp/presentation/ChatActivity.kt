package com.space.chatApp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.space.chat.R
import com.space.chat.databinding.ActivityMainBinding
import com.space.chatApp.presentation.chat_screen.ui.ChatFragment

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
        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
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