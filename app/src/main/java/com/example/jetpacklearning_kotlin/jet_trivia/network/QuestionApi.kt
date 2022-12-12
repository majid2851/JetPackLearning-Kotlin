package com.example.jetpacklearning_kotlin.jet_trivia.network

import com.example.jetpacklearning_kotlin.jet_trivia.model.QuestionModel
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi
{
    @GET("world.json")
    suspend fun getAllQuestions():QuestionModel


}