package com.example.jetpacklearning_kotlin.jet_trivia.component

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.example.jetpacklearning_kotlin.jet_trivia.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel)
{
    val questions=viewModel.getMyData().value.data?.toMutableList()
    if(viewModel.getMyData().value.loading==true) {
        CircularProgressIndicator()
        Log.i("mag2851-loading==>", "true")
    }else
    {
        questions?.forEach {
            Log.i("mag2851-question=>",it.question)
        }
    }

    Log.i("mag2851-questionSize==>",questions?.size.toString())
}