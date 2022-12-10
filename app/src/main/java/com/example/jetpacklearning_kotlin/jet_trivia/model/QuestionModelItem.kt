package com.example.jetpacklearning_kotlin.jet_trivia.model


import com.google.gson.annotations.SerializedName

data class QuestionModelItem(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("choices")
    val choices: List<String>,
    @SerializedName("question")
    val question: String
)