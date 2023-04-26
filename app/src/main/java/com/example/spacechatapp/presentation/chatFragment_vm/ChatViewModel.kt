package com.example.spacechatapp.presentation.chatFragment_vm

import androidx.lifecycle.ViewModel
import com.example.spacechatapp.domain.repository.ChatRepository

class ChatViewModel(
    private val chatRepository: ChatRepository
) : ViewModel() {

}