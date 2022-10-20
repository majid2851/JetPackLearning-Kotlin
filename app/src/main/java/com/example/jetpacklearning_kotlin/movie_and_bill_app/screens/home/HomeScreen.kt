@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.jetpacklearning_kotlin.movie_and_bill_app.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpacklearning_kotlin.movie_and_bill_app.model.MovieModel
import com.example.jetpacklearning_kotlin.movie_and_bill_app.model.getMovies
import com.example.jetpacklearning_kotlin.movie_and_bill_app.navigation.MovieScreens
import com.example.jetpacklearning_kotlin.movie_and_bill_app.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController)
{


    @Composable
    fun MainContent2(navController: NavController,movieList:List<MovieModel> = getMovies())
    {
        Column(modifier=Modifier.padding(12.dp))
        {
            LazyColumn()
            {
                items(items=movieList)
                {
                    MovieRow(movie = it)
                    { movie->
                        navController.navigate(route = MovieScreens.DetailsScreen.name+
                        "/$movie")

                    }
                }
            }
        }

    }


    Scaffold(topBar =
    {
        TopAppBar(backgroundColor = Color.Black, elevation = 5.dp)
        {
            Text(text = "Movies", color = Color.White)
        }
    },)
    {it
        MainContent2(navController)
    }





}