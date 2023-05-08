package com.space.chatApp.di

import android.content.Context
import com.space.chatApp.data.local.data_store.ThemeMode
import com.space.chatApp.data.local.data_store.themeModeDataStore
import com.space.chatApp.data.repositoryImpl.ThemeRepositoryImpl
import com.space.chatApp.domain.repository.ThemeRepository
import org.koin.dsl.module

val dataStoreModule = module {

    single {
        get<Context>().themeModeDataStore
    }

    single<ThemeRepository> {
        ThemeRepositoryImpl(
            ThemeMode(get())
        )
    }
}