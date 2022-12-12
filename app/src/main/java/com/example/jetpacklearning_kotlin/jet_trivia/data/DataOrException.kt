package com.example.jetpacklearning_kotlin.jet_trivia.data

import kotlin.Exception

data class DataOrException<T,Boolean,E:Exception>(
    var data:T?=null,
    var loading:Boolean?=null,
    var e:E ?=null
)
