package com.space.chatApp.di

import com.space.chatApp.data.mapper.MessageDomainToEntityMapper
import com.space.chatApp.data.mapper.MessageEntityToDomainMapper
import com.space.chatApp.presentation.chat_screen.mapper.MessageDomainToUIMapper
import org.koin.dsl.module

val mapperModule = module {
    single { MessageDomainToEntityMapper() }
    single { MessageEntityToDomainMapper() }
    single { MessageDomainToUIMapper() }
}