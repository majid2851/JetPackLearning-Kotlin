package com.example.jetpacklearning_kotlin.note_app.data

import com.example.jetpacklearning_kotlin.note_app.model.NoteModel

class NoteDataSource()
{
    fun loadNotes():List<NoteModel>
    {
       return listOf(
           NoteModel( title="title1", description = "this is number 1 title"),
           NoteModel( title="title2", description = "this is number 2 title"),
           NoteModel( title="title3", description = "this is number 3 title"),
           NoteModel( title="title4", description = "this is number 4 title"),
           NoteModel( title="title5", description = "this is number 5 title"),
           NoteModel( title="title6", description = "this is number 6 title"),
           NoteModel( title="title7", description = "this is number 7 title"),
           NoteModel( title="title8", description = "this is number 8 title"),
           NoteModel( title="title9", description = "this is number 9 title"),
           NoteModel( title="title10", description = "this is number 10 title"),
           NoteModel( title="title11", description = "this is number 11 title"),
           NoteModel( title="title12", description = "this is number 12 title")
       )
    }




}