package com.example.jetpacklearning_kotlin.note_app.model

import java.time.LocalDateTime
import java.util.*

data class NoteModel(
    val id: UUID =UUID.randomUUID(),
    val title:String,
    val description:String,
    val entryDate:LocalDateTime=LocalDateTime.now()
)
