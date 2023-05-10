package com.space.chatApp.di

import com.space.chatApp.data.local.data_store.ThemeMode
import com.space.chatApp.data.repositoryImpl.ChatRepositoryImpl
import com.space.chatApp.data.repositoryImpl.ThemeRepositoryImpl
import com.space.chatApp.domain.repository.ChatRepository
import com.space.chatApp.domain.repository.ThemeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ChatRepository> { ChatRepositoryImpl(get(), get(), get()) }

    single<ThemeRepository> { ThemeRepositoryImpl(ThemeMode(get())) }
}