package com.example.jetpacklearning_kotlin.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpacklearning_kotlin.weather.navigation.WeatherNavigation
import com.example.jetpacklearning_kotlin.weather.ui.theme.JetPackLearningKotlinTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent()
        {
            WeatherApp()
        }
    }
}

@Composable
fun WeatherApp()
{
    JetPackLearningKotlinTheme()
    {
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background)
        {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                WeatherNavigation()

            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview4()
{
    JetPackLearningKotlinTheme()
    {

    }
}