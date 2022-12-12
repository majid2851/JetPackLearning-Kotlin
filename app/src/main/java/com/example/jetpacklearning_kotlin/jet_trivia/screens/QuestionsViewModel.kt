package com.example.jetpacklearning_kotlin.jet_trivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacklearning_kotlin.jet_trivia.data.DataOrException
import com.example.jetpacklearning_kotlin.jet_trivia.model.QuestionModelItem
import com.example.jetpacklearning_kotlin.jet_trivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository):ViewModel()
{
    private val data:MutableState<DataOrException<ArrayList<QuestionModelItem>,
            Boolean,Exception>> = mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        getAllQuestion()
    }

    private fun getAllQuestion()
    {
        viewModelScope.launch()
        {
            data.value.loading=true
            data.value=repository.getAllQuestions()
            if (data.value.data.toString().isNotEmpty())
            {
                data.value.loading=false
            }
        }

    }


}