package com.example.jetpacklearning_kotlin.note_app.util

import androidx.room.TypeConverter
import java.util.*

class UUIDConvertor
{
    @TypeConverter
    fun fromUUID(uuid: UUID):String{
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(str:String): UUID? {
        return UUID.fromString(str)
    }






}