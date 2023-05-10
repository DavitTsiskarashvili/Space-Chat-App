package com.space.chatApp.data.mapper

import com.space.chatApp.common.Mapper
import com.space.chatApp.data.local.MessageEntity
import com.space.chatApp.domain.model.MessageDomainModel

class MessageDomainToEntityMapper : Mapper<MessageDomainModel, MessageEntity> {
    override fun invoke(model: MessageDomainModel): MessageEntity =
        with(model){
            MessageEntity(
                id = id,
                sender = sender,
                message = message,
                time = time,
                isNetworkConnection = isNetworkConnection
            )
        }
}