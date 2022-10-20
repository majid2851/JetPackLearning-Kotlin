package com.example.jetpacklearning_kotlin.movie_and_bill_app.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacklearning_kotlin.movie_and_bill_app.model.MovieModel
import com.example.jetpacklearning_kotlin.movie_and_bill_app.model.getMovies

@Preview
@Composable
fun MovieRow(movie: MovieModel= getMovies()[0], onItemClick:(String)->Unit={})
{
    var expanded by remember{
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
//        .height(130.dp)
        .clickable
        {
            onItemClick(movie.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp)
    {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start)
        {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape, elevation = 4.dp)
            {
                Icon(imageVector = Icons.Default.AccountBox
                    , contentDescription = "nothing")
                /*
                * this image code has to be added after
                * solving vpn problem,
                * 41)-Using add To Coil Image  => 6':40"
                * */
                
            }
            Column(modifier=Modifier.padding(4.dp))
            {
                Text(text = movie.title, fontSize = 17.sp)
                Text(text = movie.rating, fontSize = 12.sp )
                Text(text = movie.year , fontSize = 12.sp)
                Text(text = movie.actor, fontSize = 12.sp )

                AnimatedVisibility(visible = expanded)
                {
                    Column()
                    {
//                        Text(text = movie.plot )
//                        Text(text = movie.director )
//                        Text(text = movie.poster)
//                        Text(text = movie.genre , fontSize = 12.sp)
                          Text(text = buildAnnotatedString
                          {
                              withStyle(style = SpanStyle(color = Color.Blue, fontSize = 13.sp))
                              {
                                append("plot:",)
                              }
                              withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp))
                              {
                                  append(movie.plot)
                              }
                          })

                          Divider()
                          Text(text = "director:${movie.director}")


                    }

                }

                Icon(imageVector =if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown, contentDescription = "",
                    modifier= Modifier
                        .size(20.dp)
                        .clickable
                        {
                            expanded = !expanded

                        },
                    tint = Color.DarkGray)
            }

        }





    }

}