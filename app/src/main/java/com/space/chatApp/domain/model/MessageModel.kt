package com.space.chatApp.domain.model

data class MessageModel(
    val id: Int? = null,
    val message: String?,
    val time: Long?,
    val userID: String?,
)
