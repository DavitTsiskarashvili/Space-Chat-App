package com.space.chatApp.data.repository

import com.space.chatApp.data.local.data_store.ThemeMode
import com.space.chatApp.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow

class ThemeRepositoryImpl(private val themeMode: ThemeMode) : ThemeRepository {

    override fun getDarkModeEnabledFlow(): Flow<Boolean> {
        return themeMode.darkModeEnabledFlow
    }

    override suspend fun saveDarkModeEnabled(enabled: Boolean) {
        themeMode.saveDarkModeEnabled(enabled)
    }
}