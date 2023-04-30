package com.space.chatApp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.space.chatApp.domain.model.UserType

@Entity(tableName = "message_table")
data class ChatEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val sender: UserType?,
    val message: String?,
    val time: Long?,
)