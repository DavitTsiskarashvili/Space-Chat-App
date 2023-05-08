package com.space.chatApp.presentation.chat_activity.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import com.space.chat.databinding.ActivityMainBinding
import com.space.chatApp.domain.model.UserType
import com.space.chatApp.presentation.chat_activity.viewModel.ChatActivityViewModel
import com.space.chatApp.presentation.chat_screen.ui.ChatFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ChatActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null){
            fragmentSetup()
        }

        changeThemeModes()

    }

    private fun fragmentSetup() {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.topFragment.id, ChatFragment(), UserType.FIRST_USER_ID)
            replace(binding.bottomFragment.id, ChatFragment(), UserType.SECOND_USER_ID)
        }.commit()
    }

    private fun changeThemeModes() {
        viewModel.darkModeEnabledFlow.onEach { darkModeEnabled ->
            if (darkModeEnabled) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }.launchIn(lifecycleScope)

        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.saveDarkModeEnabled(isChecked)
        }
    }

}