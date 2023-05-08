package com.space.chatApp.presentation.chat_screen.mapper

import com.space.chatApp.common.Mapper
import com.space.chatApp.common.extensions.dateFormat
import com.space.chatApp.domain.model.MessageDomainModel
import com.space.chatApp.presentation.chat_screen.model.MessageUIModel

class MessageDomainToUIMapper : Mapper<MessageDomainModel, MessageUIModel> {
    override fun invoke(model: MessageDomainModel): MessageUIModel =
        MessageUIModel(
            id = model.id,
            sender = model.sender,
            message = model.message,
            time = model.time?.dateFormat(),
            isNetworkConnection = model.isNetworkConnection
        )
}