package com.space.chatApp.data.mapper

import com.space.chatApp.common.extensions.convertDateToLong
import com.space.chatApp.common.extensions.dateFormat
import com.space.chatApp.data.local.MessageEntity
import com.space.chatApp.domain.model.MessageDomainModel
import com.space.chatApp.presentation.chat_screen.model.MessageUiModel

fun MessageDomainModel.toEntity() = MessageEntity(
    id = id,
    sender = sender,
    message = message,
    time = time,
    isNetworkConnection = isNetworkConnection
)
fun MessageEntity.toDomainModel() = MessageDomainModel(
    id = id,
    sender = sender,
    message = message,
    time = time,
    isNetworkConnection = isNetworkConnection
)

fun MessageDomainModel.toUiModel() = MessageUiModel(
    id = id,
    sender = sender,
    message = message,
    time = time?.dateFormat(),
    isNetworkConnection = isNetworkConnection
)

fun MessageUiModel.toDomainModel() = MessageDomainModel(
    id = id,
    sender = sender,
    message = message,
    time = time?.let {convertDateToLong(it)},
    isNetworkConnection = isNetworkConnection
)