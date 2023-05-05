package com.space.chatApp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MessageEntity::class], version = 2)
abstract class ChatDataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}