package com.example.jetpacklearning_kotlin.note_app.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao
{
    @Query("Select * from notes_tbl")
    fun getNotes():Flow<List<NoteModel>>

    @Query("Select * from notes_tbl where id=:id")
    suspend fun getNoteById(id:String):NoteModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:NoteModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: NoteModel)

    @Query("Delete from notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: NoteModel)
}