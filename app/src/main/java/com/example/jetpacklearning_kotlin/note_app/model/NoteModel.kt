package com.example.jetpacklearning_kotlin.note_app.model

import android.os.Build
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "notes_tbl")
data class NoteModel @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey
    val id: UUID =UUID.randomUUID(),
    @ColumnInfo(name = "notes_title")
    val title:String,
    @ColumnInfo(name = "notes_description")
    val description:String,
    @ColumnInfo(name = "notes_entryDate")
    val entryDate:Date=Date.from(Instant.now())
)
