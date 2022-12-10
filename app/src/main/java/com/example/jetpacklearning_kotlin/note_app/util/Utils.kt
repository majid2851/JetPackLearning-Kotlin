package com.example.jetpacklearning_kotlin.note_app.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time:Long): String
{
     val date= Date(time)
     val myFormat=SimpleDateFormat("EEE ,d MMM hh:mm:aaa",
     Locale.getDefault())
    return myFormat.format(date)
 }