package com.example.jetpacklearning_kotlin.movie_and_bill_app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpacklearning_kotlin.movie_and_bill_app.activity.ui.theme.JetPackLearningKotlinTheme
import com.example.jetpacklearning_kotlin.movie_and_bill_app.navigation.MovieNavigation

class MovieActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContent()
        {
            MyApp()
            {
                MovieNavigation()
            }
        }
    }


    @Composable
    fun MyApp(content: @Composable ()->Unit)
    {
        JetPackLearningKotlinTheme()
        {
            content()

        }

    }




    @Composable
    @Preview
    fun DefaultPreview()
    {
        MyApp()
        {
            MovieNavigation()
        }
    }


}

