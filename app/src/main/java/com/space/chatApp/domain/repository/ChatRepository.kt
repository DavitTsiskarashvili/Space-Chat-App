package com.space.chatApp.domain.repository

import com.space.chatApp.domain.model.MessageDomainModel
import com.space.chatApp.presentation.chat_screen.model.MessageUiModel
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun showMessages(): Flow<List<MessageDomainModel>>

    suspend fun insertMessage(message: MessageDomainModel)
}