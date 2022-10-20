package com.example.jetpacklearning_kotlin.movie_and_bill_app.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.jetpacklearning_kotlin.movie_and_bill_app.model.MovieModel
import com.example.jetpacklearning_kotlin.movie_and_bill_app.model.getMovies
import com.example.jetpacklearning_kotlin.movie_and_bill_app.widgets.MovieRow

@Composable
fun DetailScreen(navController: NavController, movieId: String?)
{
    val movie= getMovies().filter { movie->
        movie.id==movieId
    }
     Scaffold(topBar =
     {
         TopAppBar(backgroundColor = Color.Black, elevation = 5.dp)
         {
             Row(horizontalArrangement = Arrangement.Start)
             {
                 Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                     modifier = Modifier.clickable {
                        navController.popBackStack()
                     }, tint = Color.White)
                 Spacer(modifier = Modifier.width(20.dp))
                 Text(text = "Movies", color = Color.White)
             }
         }
     })
     {it
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight())
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top)
            {
                MovieRow(movie = movie.get(0)) 
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorizontalImgSlider(movie)

            }
        }

     }





}

@Composable
private fun HorizontalImgSlider(movie: List<MovieModel>) {
    LazyRow()
    {
        items(movie.get(0).images)
        { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(200.dp), elevation = 5.dp
            )
            {
                AsyncImage(model = image, contentDescription = null)

            }

        }


    }
}
