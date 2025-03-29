package com.espi.brainbattles2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.espi.brainbattles2.model.Question
import com.espi.brainbattles2.model.Category

class GameViewModel : ViewModel() {
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> = _currentQuestion

    private val _isGameOver = MutableLiveData(false)
    val isGameOver: LiveData<Boolean> = _isGameOver

    private val questions = mutableListOf<Question>()
    private var currentQuestionIndex = 0
    private var isInitialized = false

    init {
        loadQuestions()
        showNextQuestion()
    }

    private fun loadQuestions() {
        if (!isInitialized) {
            questions.addAll(listOf(
                Question(
                    1,
                    "¿Quién fue el primer presidente de los Estados Unidos?",
                    listOf("George Washington", "Thomas Jefferson", "John Adams", "Benjamin Franklin"),
                    0,
                    Category.HISTORY
                ),
                Question(
                    2,
                    "¿Cuál es el planeta más grande del sistema solar?",
                    listOf("Saturno", "Júpiter", "Neptuno", "Urano"),
                    1,
                    Category.SCIENCE
                ),
                Question(
                    3,
                    "¿Cuál es el elemento químico más abundante en el universo?",
                    listOf("Helio", "Hidrógeno", "Oxígeno", "Carbono"),
                    1,
                    Category.SCIENCE
                ),
                Question(
                    4,
                    "¿En qué año comenzó la Segunda Guerra Mundial?",
                    listOf("1940", "1939", "1941", "1942"),
                    1,
                    Category.HISTORY
                ),
                Question(
                    5,
                    "¿Cuál es el río más largo del mundo?",
                    listOf("Amazonas", "Nilo", "Yangtsé", "Misisipi"),
                    0,
                    Category.GEOGRAPHY
                ),
                Question(
                    6,
                    "¿Quién pintó la Mona Lisa?",
                    listOf("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Michelangelo"),
                    2,
                    Category.ART
                ),
                Question(
                    7,
                    "¿Cuál es el país más grande del mundo por superficie?",
                    listOf("China", "Estados Unidos", "Rusia", "Canadá"),
                    2,
                    Category.GEOGRAPHY
                ),
                Question(
                    8,
                    "¿En qué año se fundó la ONU?",
                    listOf("1946", "1945", "1947", "1948"),
                    1,
                    Category.HISTORY
                ),
                Question(
                    9,
                    "¿Cuál es el metal más abundante en la corteza terrestre?",
                    listOf("Hierro", "Cobre", "Aluminio", "Zinc"),
                    2,
                    Category.SCIENCE
                ),
                Question(
                    10,
                    "¿Quién escribió 'Don Quijote de la Mancha'?",
                    listOf("Gabriel García Márquez", "Miguel de Cervantes", "Pablo Neruda", "Federico García Lorca"),
                    1,
                    Category.LITERATURE
                ),
                Question(
                    11,
                    "¿Cuál es el océano más grande del mundo?",
                    listOf("Atlántico", "Índico", "Pacífico", "Ártico"),
                    2,
                    Category.GEOGRAPHY
                ),
                Question(
                    12,
                    "¿En qué año se inventó la bombilla eléctrica?",
                    listOf("1879", "1880", "1878", "1881"),
                    0,
                    Category.SCIENCE
                ),
                Question(
                    13,
                    "¿Quién compuso la 'Novena Sinfonía'?",
                    listOf("Mozart", "Bach", "Beethoven", "Chopin"),
                    2,
                    Category.MUSIC
                ),
                Question(
                    14,
                    "¿Cuál es el país con más habitantes del mundo?",
                    listOf("India", "China", "Estados Unidos", "Indonesia"),
                    1,
                    Category.GEOGRAPHY
                ),
                Question(
                    15,
                    "¿En qué año cayó el Imperio Romano de Occidente?",
                    listOf("476 d.C.", "486 d.C.", "466 d.C.", "496 d.C."),
                    0,
                    Category.HISTORY
                )
            ))
            isInitialized = true
        }
    }

    fun showNextQuestion() {
        if (currentQuestionIndex < questions.size) {
            _currentQuestion.value = questions[currentQuestionIndex]
        } else {
            _isGameOver.value = true
        }
    }

    fun checkAnswer(selectedAnswerIndex: Int) {
        val currentQuestion = _currentQuestion.value
        if (currentQuestion != null && selectedAnswerIndex == currentQuestion.correctAnswerIndex) {
            _score.value = (_score.value ?: 0) + 10
        }
        currentQuestionIndex++
        showNextQuestion()
    }

    fun resetGame() {
        _score.value = 0
        currentQuestionIndex = 0
        _isGameOver.value = false
        loadQuestions()
        showNextQuestion()
    }
} 