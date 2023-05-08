package com.space.chatApp.di

import com.space.chatApp.data.mapper.MessageDomainToEntityMapper
import com.space.chatApp.data.mapper.MessageEntityToDomainMapper
import com.space.chatApp.data.repositoryImpl.ChatRepositoryImpl
import com.space.chatApp.data.repositoryImpl.ThemeRepositoryImpl
import com.space.chatApp.domain.repository.ChatRepository
import com.space.chatApp.domain.repository.ThemeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ChatRepository> {
        ChatRepositoryImpl(
            get(),
            MessageDomainToEntityMapper(),
            MessageEntityToDomainMapper()
        )
    }

    single<ThemeRepository> { ThemeRepositoryImpl(get()) }
}