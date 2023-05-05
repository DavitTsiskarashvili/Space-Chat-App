package com.space.chatApp.domain.model

data class MessageDomainModel(
    val id: Int? = null,
    val message: String?,
    val time: Long?,
    val sender: String?,
    val isNetworkConnection: Boolean = true
)
