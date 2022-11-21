package com.example.jetpacklearning_kotlin.note_app.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetpacklearning_kotlin.note_app.data.NoteDataSource
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel

class NoteViewModel :ViewModel()
{
    var noteList= mutableStateListOf<NoteModel>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }
    fun addNote(note:NoteModel)
    {
        noteList.add(note)

    }
    fun removeNote(note:NoteModel)
    {
        noteList.remove(note)
    }

    fun getAllNotes():List<NoteModel>
    {
        return noteList
    }

}