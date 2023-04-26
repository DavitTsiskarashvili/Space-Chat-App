package com.example.spacechatapp.presentation.chat_screen.viewModel

import androidx.lifecycle.ViewModel
import com.example.spacechatapp.domain.repository.ChatRepository

class ChatViewModel(
    private val chatRepository: ChatRepository
) : ViewModel() {

}