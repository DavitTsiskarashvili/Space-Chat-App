package com.space.chatApp.presentation.chat_screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.chatApp.common.extensions.getTimeInMills
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ChatViewModel(
    private val chatRepository: ChatRepository
) : ViewModel() {

    private var _messages = MutableSharedFlow<MessageModel?>()
    val messages get() = _messages.asSharedFlow()

    fun getAllMessages(): Flow<List<MessageModel>> = chatRepository.showMessages()

    private fun provideMessageModel(messageInput: String, tag: String) = MessageModel(
        sender = tag, message = messageInput, time = getTimeInMills()
    )

    fun sendMessage(messageInput: String, tag: String) {
        if (messageInput.isNotEmpty()) {
            viewModelScope.launch {
                _messages.emit(provideMessageModel(messageInput, tag))
                insertMessages(messageModel = provideMessageModel(messageInput, tag))
            }
        }
    }

    private suspend fun insertMessages(messageModel: MessageModel){
        chatRepository.insertMessage(messageModel)
    }

}