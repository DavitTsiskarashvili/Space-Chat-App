package com.space.chatApp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.space.chatApp.data.local.data_store.ThemeMode
import com.space.chatApp.data.local.data_store.themeModeDataStore
import com.space.chatApp.data.repositoryImpl.ThemeRepositoryImpl
import com.space.chatApp.domain.repository.ThemeRepository
import org.koin.dsl.module


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "darkMode_preference"
)

private fun provideDataStore(context: Context): DataStore<Preferences> {
    return context.dataStore
}

val dataStoreModule = module {
    single { provideDataStore(get()) }
    single<ThemeRepository> { ThemeRepositoryImpl(ThemeMode(get())) }

}