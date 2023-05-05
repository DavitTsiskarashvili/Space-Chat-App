package com.space.chatApp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.space.chat.databinding.ActivityMainBinding
import com.space.chatApp.domain.model.UserType
import com.space.chatApp.presentation.chat_screen.ui.ChatFragment
import com.space.chatApp.presentation.utils.ThemeUtils

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ThemeUtils.applyThemeMode(this)
        fragmentSetup()
        changeDayNightModes()
    }


    private fun fragmentSetup() {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.topFragment.id, ChatFragment(), UserType.FIRST_USER_ID)
            replace(binding.bottomFragment.id, ChatFragment(), UserType.SECOND_USER_ID)
        }.commit()
    }


    private fun changeDayNightModes() {
        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val themeMode = if (isChecked) ThemeUtils.DARK_MODE else ThemeUtils.LIGHT_MODE
            ThemeUtils.setThemeMode(this, themeMode)
            ThemeUtils.applyThemeMode(this)
        }
    }

}