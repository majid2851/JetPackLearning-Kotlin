package com.example.jetpacklearning_kotlin.jet_trivia.repository

import com.example.jetpacklearning_kotlin.jet_trivia.data.DataOrException
import com.example.jetpacklearning_kotlin.jet_trivia.model.QuestionModel
import com.example.jetpacklearning_kotlin.jet_trivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api:QuestionApi)
{
    private val questionList=
        DataOrException<ArrayList<QuestionModel>,Boolean,Exception>()









}