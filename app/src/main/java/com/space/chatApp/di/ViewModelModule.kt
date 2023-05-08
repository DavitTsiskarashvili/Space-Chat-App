package com.space.chatApp.di

import com.space.chatApp.presentation.chat_activity.viewModel.ChatActivityViewModel
import com.space.chatApp.presentation.chat_screen.mapper.MessageDomainToUIMapper
import com.space.chatApp.presentation.chat_screen.viewModel.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChatViewModel (get(), MessageDomainToUIMapper()) }
    viewModel { ChatActivityViewModel (get()) }
}