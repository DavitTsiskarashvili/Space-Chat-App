package com.space.chatApp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message_table")
data class MessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val sender: String?,
    val message: String?,
    val time: Long?,
    val isNetworkConnection: Boolean = true
)