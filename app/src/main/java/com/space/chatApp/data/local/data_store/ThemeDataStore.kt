package com.space.chatApp.data.local.data_store


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

// Data Store class which handles users preference of light and dark mode
private const val THEME_MODE_FILE_NAME = "theme_mode"

class ThemeMode(private val themeDataStore: DataStore<Preferences>) {

    suspend fun saveDarkModeEnabled(enabled: Boolean) {
        themeDataStore.edit { preferences ->
            preferences[DARK_MODE_ENABLED] = enabled
        }
    }

    val darkModeEnabledFlow: Flow<Boolean> = themeDataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[DARK_MODE_ENABLED] ?: false
        }

    companion object PreferencesKeys {
        val DARK_MODE_ENABLED = booleanPreferencesKey("dark_mode_enabled")
    }

}

val Context.themeModeDataStore: DataStore<Preferences> by preferencesDataStore(
    name = THEME_MODE_FILE_NAME
)
