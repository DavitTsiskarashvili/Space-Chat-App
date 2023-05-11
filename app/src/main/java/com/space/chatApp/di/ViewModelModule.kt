package com.space.chatApp.di

import com.space.chatApp.presentation.chat_activity.viewModel.ChatActivityViewModel
import com.space.chatApp.presentation.chat_screen.view_model.ChatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChatViewModel (get(), get()) }
    viewModel { ChatActivityViewModel (get()) }
}