package com.example.quiz_app

data class Question(
    val questionTitle: String,
    val imageUrl: String,
    val options: List<String>,
    val rightAns: Int
)