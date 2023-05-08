package com.space.chatApp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {
    @Query("SELECT * FROM message_table")
    fun getAll(): Flow<List<MessageEntity>>

    @Insert
    suspend fun insertMessage(vararg message: MessageEntity)
}