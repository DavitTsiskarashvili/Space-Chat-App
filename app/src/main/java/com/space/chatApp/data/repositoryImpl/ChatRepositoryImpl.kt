package com.space.chatApp.data.repositoryImpl

import com.space.chatApp.data.local.ChatDao
import com.space.chatApp.data.mapper.toEntity
import com.space.chatApp.data.mapper.toModel
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.domain.repository.ChatRepository
import kotlinx.coroutines.flow.map

class ChatRepositoryImpl(private val dao: ChatDao): ChatRepository {

    override fun showMessages() = dao.getAll().map { chat ->
        chat.map {
            it.toModel()
        }
    }

    override suspend fun insertMessage(message: MessageModel) {
        dao.insertMessage(message.toEntity())
    }
}