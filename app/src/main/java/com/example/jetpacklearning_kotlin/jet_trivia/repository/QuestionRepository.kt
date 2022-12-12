package com.example.jetpacklearning_kotlin.jet_trivia.repository

import android.util.Log
import com.example.jetpacklearning_kotlin.jet_trivia.data.DataOrException
import com.example.jetpacklearning_kotlin.jet_trivia.model.QuestionModelItem
import com.example.jetpacklearning_kotlin.jet_trivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api:QuestionApi)
{
    private val dataOrException=
        DataOrException<ArrayList<QuestionModelItem>,Boolean,Exception>()

    suspend fun getAllQuestions():DataOrException<ArrayList<QuestionModelItem>,Boolean,Exception>
    {
        try
        {
            dataOrException.loading=true
            dataOrException.data=api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()){ dataOrException.loading=false }

        }catch (exception:Exception){
            dataOrException.e=exception
            Log.d("Exc","getAllQuestions:"+exception.toString())
        }
        return dataOrException
    }







}