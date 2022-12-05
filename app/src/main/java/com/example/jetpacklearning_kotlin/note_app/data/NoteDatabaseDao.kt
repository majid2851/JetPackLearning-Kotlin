package com.example.jetpacklearning_kotlin.note_app.data

import androidx.room.*
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel

@Dao
interface NoteDatabaseDao
{
    @Query("Select * from notes_tbl")
    fun getNotes():List<NoteModel>

    @Query("Select * from notes_tbl where id=:id")
    fun getNoteById(id:String):NoteModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note:NoteModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: NoteModel)

    @Query("Delete from notes_tbl")
    fun deleteAll()

    @Delete
    fun deleteNote(id:String)
}