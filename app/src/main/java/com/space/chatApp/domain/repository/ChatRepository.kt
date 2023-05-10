package com.space.chatApp.domain.repository

import com.space.chatApp.domain.model.MessageDomainModel
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun showMessages(): Flow<List<MessageDomainModel>>

    suspend fun insertMessage(message: MessageDomainModel)
}