package com.example.jetpacklearning_kotlin.note_app.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacklearning_kotlin.note_app.data.NoteDataSource
import com.example.jetpacklearning_kotlin.note_app.data.NoteDatabaseDao
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel
import com.example.jetpacklearning_kotlin.note_app.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel  @Inject constructor(private val repository: NoteRepository) :ViewModel()
{
    val _noteList= MutableStateFlow<List<NoteModel>>(emptyList())
    var noteList=_noteList.asStateFlow()

    init
    {
       viewModelScope.launch(Dispatchers.IO)
       {
           repository.getNotes().distinctUntilChanged().collect()
           {
               if (it.isNullOrEmpty())
               {
                   Log.i("mag2851-list","=emptyList")
               }else
               {
                    _noteList.value=it
               }
           }
       }
    }
    suspend fun addNote(note:NoteModel)
    {
        viewModelScope.launch { repository.addNote(note) }
    }
    suspend fun removeNote(note:NoteModel)
    {
        viewModelScope.launch { repository.deleteNote(note)}
    }
    suspend fun updateNote(note: NoteModel){
        viewModelScope.launch { repository.updateNote(note) }
    }


}