package com.example.jetpacklearning_kotlin.note_app.repository

import com.example.jetpacklearning_kotlin.note_app.data.NoteDatabaseDao
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository
    @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao)
{
    fun getNotes(): Flow<List<NoteModel>> {
        return noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
    }
    suspend fun addNote(noteModel: NoteModel){
        noteDatabaseDao.insertNote(noteModel)
    }
    suspend fun deleteNote(noteModel: NoteModel){
        noteDatabaseDao.deleteNote(noteModel)
    }
    suspend fun deleteAllNote(){
        noteDatabaseDao.deleteAll()
    }
    suspend fun updateNote(noteModel: NoteModel){
        noteDatabaseDao.updateNote(noteModel)
    }







}