package com.space.chatApp.presentation.chat_activity.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.chatApp.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ChatActivityViewModel(private val repository: ThemeRepository) : ViewModel() {

    val darkModeEnabledFlow: Flow<Boolean> = repository.getDarkModeEnabledFlow()

    fun saveDarkModeEnabled(darkModeEnabled: Boolean) {
        viewModelScope.launch {
            repository.saveDarkModeEnabled(darkModeEnabled)
        }
    }
}
