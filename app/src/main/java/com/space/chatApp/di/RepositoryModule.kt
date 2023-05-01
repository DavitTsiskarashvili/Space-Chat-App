package com.space.chatApp.di

import com.space.chatApp.data.repositoryImpl.ChatRepositoryImpl
import com.space.chatApp.domain.repository.ChatRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ChatRepository> { ChatRepositoryImpl(get()) }
}