package com.espi.brainbattles2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import com.espi.brainbattles2.viewmodel.GameViewModel

@Composable
fun GameScreen(
    onGameOver: () -> Unit,
    viewModel: GameViewModel = viewModel()
) {
    val currentQuestion by viewModel.currentQuestion.observeAsState()
    val score by viewModel.score.observeAsState(0)
    val isGameOver by viewModel.isGameOver.observeAsState(false)

    LaunchedEffect(Unit) {
        viewModel.resetGame()
    }

    LaunchedEffect(isGameOver) {
        if (isGameOver) {
            // Pequeño retraso para mostrar el resultado final
            kotlinx.coroutines.delay(1000)
            onGameOver()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Puntuación: $score",
            style = MaterialTheme.typography.headlineMedium
        )

        currentQuestion?.let { question ->
            Text(
                text = question.question,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            question.options.forEachIndexed { index, option ->
                Button(
                    onClick = { viewModel.checkAnswer(index) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = option)
                }
            }
        }
    }
} 