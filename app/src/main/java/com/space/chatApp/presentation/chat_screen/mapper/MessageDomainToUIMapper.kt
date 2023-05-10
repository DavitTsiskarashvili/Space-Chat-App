package com.space.chatApp.presentation.chat_screen.mapper

import com.space.chatApp.common.Mapper
import com.space.chatApp.common.extensions.dateFormat
import com.space.chatApp.domain.model.MessageDomainModel
import com.space.chatApp.presentation.chat_screen.model.MessageUIModel

class MessageDomainToUIMapper : Mapper<MessageDomainModel, MessageUIModel> {
    override fun invoke(model: MessageDomainModel): MessageUIModel =
        with(model) {
            MessageUIModel(
                id = id,
                sender = sender,
                message = message,
                time = time?.dateFormat(),
                isNetworkConnection = isNetworkConnection
            )
        }
}