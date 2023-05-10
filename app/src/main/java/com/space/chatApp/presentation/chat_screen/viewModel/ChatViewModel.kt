package com.space.chatApp.presentation.chat_screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.chatApp.common.extensions.getTimeInMills
import com.space.chatApp.domain.model.MessageDomainModel
import com.space.chatApp.domain.repository.ChatRepository
import com.space.chatApp.presentation.chat_screen.mapper.MessageDomainToUIMapper
import com.space.chatApp.presentation.chat_screen.model.MessageUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ChatViewModel(
    private val chatRepository: ChatRepository,
    private val domainToUIMapper: MessageDomainToUIMapper
) : ViewModel() {

    private var _messages = MutableSharedFlow<MessageDomainModel?>()
    val messages get() = _messages.asSharedFlow()

    fun getAllMessages(): Flow<List<MessageUIModel>> =
        chatRepository.showMessages().map { messageModel ->
            messageModel.map { message ->
                domainToUIMapper(message)
            }
        }

    private fun provideMessageModel(
        messageInput: String,
        userID: String,
        isNetworkConnection: Boolean
    ) =
        MessageDomainModel(
            sender = userID,
            message = messageInput,
            time = getTimeInMills(),
            isNetworkConnection = isNetworkConnection
        )

    fun sendMessage(messageInput: String, userID: String, isNetworkConnection: Boolean) {
        if (messageInput.isNotEmpty()) {
            viewModelScope.launch {
                _messages.emit(provideMessageModel(messageInput, userID, isNetworkConnection))
                insertMessages(
                    messageModel = provideMessageModel(
                        messageInput,
                        userID,
                        isNetworkConnection
                    )
                )
            }
        }
    }

    private suspend fun insertMessages(messageModel: MessageDomainModel) {
        chatRepository.insertMessage(messageModel)
    }

    fun filterMessagesWithoutInternet(message: List<MessageUIModel>, userID: String): List<MessageUIModel> {
        return message.filter {
            it.sender == userID || it.isNetworkConnection
        }
    }

}