package com.space.chatApp.domain.repository

import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    fun getDarkModeEnabledFlow(): Flow<Boolean>
    suspend fun saveDarkModeEnabled(enabled: Boolean)
}