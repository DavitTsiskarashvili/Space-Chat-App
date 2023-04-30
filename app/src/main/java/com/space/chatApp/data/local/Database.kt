package com.space.chatApp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ChatEntity::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}