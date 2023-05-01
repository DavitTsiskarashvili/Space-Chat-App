package com.space.chatApp.presentation.chat_screen.viewModel

import androidx.lifecycle.ViewModel
import com.space.chatApp.domain.repository.ChatRepository

class ChatViewModel(
    private val chatRepository: ChatRepository
) : ViewModel() {

}