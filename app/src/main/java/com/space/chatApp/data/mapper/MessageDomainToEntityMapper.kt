package com.space.chatApp.data.mapper

import com.space.chatApp.common.Mapper
import com.space.chatApp.data.local.MessageEntity
import com.space.chatApp.domain.model.MessageDomainModel

class MessageDomainToEntityMapper : Mapper<MessageDomainModel, MessageEntity> {
    override fun invoke(model: MessageDomainModel): MessageEntity =
        MessageEntity(
            id = model.id,
            sender = model.sender,
            message = model.message,
            time = model.time,
            isNetworkConnection = model.isNetworkConnection
        )
}