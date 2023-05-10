package com.space.chatApp.data.mapper

import com.space.chatApp.common.Mapper
import com.space.chatApp.data.local.MessageEntity
import com.space.chatApp.domain.model.MessageDomainModel

class MessageEntityToDomainMapper : Mapper<MessageEntity, MessageDomainModel> {
    override fun invoke(model: MessageEntity): MessageDomainModel =
        with(model) {
            MessageDomainModel(
                id = id,
                sender = sender,
                message = message,
                time = time,
                isNetworkConnection = isNetworkConnection
            )
        }
}