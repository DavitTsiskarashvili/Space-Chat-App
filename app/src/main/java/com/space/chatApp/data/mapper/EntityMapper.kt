package com.space.chatApp.data.mapper

import com.space.chatApp.data.local.MessageEntity
import com.space.chatApp.domain.model.MessageModel

fun MessageModel.toEntity() = MessageEntity(
    id = id,
    sender = sender,
    message = message,
    time = time,
)
fun MessageEntity.toModel() = MessageModel(
    id = id,
    sender = sender,
    message = message,
    time = time,
)