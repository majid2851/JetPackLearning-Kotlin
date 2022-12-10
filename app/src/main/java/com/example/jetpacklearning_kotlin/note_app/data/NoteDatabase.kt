package com.example.jetpacklearning_kotlin.note_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel
import com.example.jetpacklearning_kotlin.note_app.util.DateConvertor
import com.example.jetpacklearning_kotlin.note_app.util.UUIDConvertor

@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
@TypeConverters(DateConvertor::class,UUIDConvertor::class)
abstract class NoteDatabase: RoomDatabase()
{
    abstract fun noteDao():NoteDatabaseDao

}