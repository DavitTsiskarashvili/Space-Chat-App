package com.space.chatApp.data.mapper

import com.space.chatApp.data.local.ChatEntity
import com.space.chatApp.domain.model.MessageModel
import com.space.chatApp.domain.model.UserType

fun MessageModel.toEntity() = ChatEntity(
    id = id,
    sender = sender,
    message = message,
    time = time,
)
fun ChatEntity.toModel() = MessageModel(
    id = id,
    sender = sender,
    message = message,
    time = time,
)