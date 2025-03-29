package com.espi.brainbattles2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import com.espi.brainbattles2.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = viewModel()
) {
    val backgroundColor by viewModel.backgroundColor.observeAsState(0xFF6200EE.toInt())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Configuración",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Color de fondo",
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorOption(
                color = Color(0xFF6200EE),
                isSelected = backgroundColor == 0xFF6200EE.toInt(),
                onClick = { viewModel.updateBackgroundColor(0xFF6200EE.toInt()) }
            )
            ColorOption(
                color = Color(0xFF03DAC6),
                isSelected = backgroundColor == 0xFF03DAC6.toInt(),
                onClick = { viewModel.updateBackgroundColor(0xFF03DAC6.toInt()) }
            )
            ColorOption(
                color = Color(0xFF3700B3),
                isSelected = backgroundColor == 0xFF3700B3.toInt(),
                onClick = { viewModel.updateBackgroundColor(0xFF3700B3.toInt()) }
            )
            ColorOption(
                color = Color(0xFF018786),
                isSelected = backgroundColor == 0xFF018786.toInt(),
                onClick = { viewModel.updateBackgroundColor(0xFF018786.toInt()) }
            )
        }
    }
}

@Composable
private fun ColorOption(
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(color)
            .border(
                width = 2.dp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                shape = CircleShape
            )
            .clickable(onClick = onClick)
    )
} 