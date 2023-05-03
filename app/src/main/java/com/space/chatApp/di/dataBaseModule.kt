package com.space.chatApp.di

import android.content.Context
import androidx.room.Room
import com.space.chatApp.data.local.DataBase
import org.koin.dsl.module

private fun provideChatDataBase(context: Context): DataBase {
    return Room.databaseBuilder(context, DataBase::class.java, "chat_database")
        .fallbackToDestructiveMigration().build()
}

private fun provideDao(db: DataBase) = db.chatDao()

val dataBaseModule = module {
    single { provideChatDataBase(get()) }
    single { provideDao(get()) }
}