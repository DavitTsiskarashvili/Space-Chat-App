package com.space.chatApp.domain.repository

import com.space.chatApp.domain.model.MessageModel
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun showMessages(): Flow<List<MessageModel>>

    suspend fun insertMessage(message: MessageModel)
}