package com.example.jetpacklearning_kotlin.note_app.util

import androidx.room.TypeConverter
import java.sql.Timestamp
import java.util.*

class DateConvertor
{
    @TypeConverter
    fun timeStampFromDate(date:Date):Long
    {
        return date.time
    }
    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long):Date
    {
        return Date(timestamp)
    }

}