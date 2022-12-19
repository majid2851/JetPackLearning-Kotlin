package com.example.jetpacklearning_kotlin.jet_trivia.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacklearning_kotlin.jet_trivia.component.Questions


/*viewModel:QuestionsViewModel=hiltViewModel() ???*/
@Composable
fun TrivialHome(viewModel:QuestionsViewModel = viewModel())
{
    Questions(viewModel)
}