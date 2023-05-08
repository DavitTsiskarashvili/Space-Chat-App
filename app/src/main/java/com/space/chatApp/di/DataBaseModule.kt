package com.space.chatApp.di

import android.content.Context
import androidx.room.Room
import com.space.chatApp.data.local.ChatDataBase
import org.koin.dsl.module

private fun provideChatDataBase(context: Context): ChatDataBase {
    return Room.databaseBuilder(context, ChatDataBase::class.java, "chat_database")
        .fallbackToDestructiveMigration().build()
}

private fun provideDao(db: ChatDataBase) = db.chatDao()

val dataBaseModule = module {
    single { provideChatDataBase(get()) }
    single { provideDao(get()) }
}