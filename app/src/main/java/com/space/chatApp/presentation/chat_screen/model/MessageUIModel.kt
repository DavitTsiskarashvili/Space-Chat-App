package com.space.chatApp.presentation.chat_screen.model

data class MessageUIModel(
    val id: Int? = null,
    val message: String?,
    val time: String?,
    val sender: String?,
    val isOnline: Boolean = true
)
