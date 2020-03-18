package com.p7k.retrofit2homework.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)