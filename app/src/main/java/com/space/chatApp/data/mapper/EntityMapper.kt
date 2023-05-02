package com.space.chatApp.data.mapper

import com.space.chatApp.data.local.ChatEntity
import com.space.chatApp.domain.model.MessageModel

fun MessageModel.toEntity() = ChatEntity(
    id = id,
    sender = userID,
    message = message,
    time = time,
)
fun ChatEntity.toModel() = MessageModel(
    id = id,
    userID = sender,
    message = message,
    time = time,
)