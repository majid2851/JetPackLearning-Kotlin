package com.example.jetpacklearning_kotlin.note_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase()
{
    abstract fun notDao():NoteDatabaseDao







}