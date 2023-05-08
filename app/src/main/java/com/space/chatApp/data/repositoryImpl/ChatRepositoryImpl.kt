package com.space.chatApp.data.repositoryImpl

import com.space.chatApp.data.local.ChatDao
import com.space.chatApp.data.mapper.MessageDomainToEntityMapper
import com.space.chatApp.data.mapper.MessageEntityToDomainMapper
import com.space.chatApp.data.mapper.toEntity
import com.space.chatApp.data.mapper.toDomainModel
import com.space.chatApp.domain.model.MessageDomainModel
import com.space.chatApp.domain.repository.ChatRepository
import kotlinx.coroutines.flow.map

class ChatRepositoryImpl(
    private val dao: ChatDao,
    private val domainToEntityMapper: MessageDomainToEntityMapper,
    private val entityToDomainMapper: MessageEntityToDomainMapper
): ChatRepository {
    override fun showMessages() = dao.getAll().map { chat ->
        chat.map { entity ->
            entityToDomainMapper(entity)
        }
    }

    override suspend fun insertMessage(message: MessageDomainModel) {
        dao.insertMessage(domainToEntityMapper(message))
    }
}