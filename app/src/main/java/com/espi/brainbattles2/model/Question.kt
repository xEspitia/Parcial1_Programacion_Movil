package com.espi.brainbattles2.model

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val category: Category
)

enum class Category {
    HISTORY,
    SCIENCE,
    GEOGRAPHY,
    ART,
    LITERATURE,
    MUSIC
} 