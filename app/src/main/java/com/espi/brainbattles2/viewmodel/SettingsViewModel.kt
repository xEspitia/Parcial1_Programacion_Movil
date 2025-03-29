package com.espi.brainbattles2.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val _backgroundColor = MutableLiveData<Int>()
    val backgroundColor: LiveData<Int> = _backgroundColor

    private val backgroundColorKey = intPreferencesKey("background_color")

    init {
        loadBackgroundColor()
    }

    private fun loadBackgroundColor() {
        viewModelScope.launch {
            getApplication<Application>().dataStore.data.map { preferences ->
                preferences[backgroundColorKey] ?: 0xFF6200EE.toInt()
            }.collect { color ->
                _backgroundColor.value = color
            }
        }
    }

    fun updateBackgroundColor(color: Int) {
        viewModelScope.launch {
            getApplication<Application>().dataStore.edit { preferences ->
                preferences[backgroundColorKey] = color
            }
            _backgroundColor.value = color
        }
    }
} 