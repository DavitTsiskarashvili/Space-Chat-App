package com.example.spacechatapp.domain.model

data class MessageModel(
    val id: Int?,
    val message: String?,
    val time: Long?,
    val sender: String,
)
