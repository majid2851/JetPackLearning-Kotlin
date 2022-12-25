package com.example.jetpacklearning_kotlin.weather.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpacklearning_kotlin.R
import com.example.jetpacklearning_kotlin.jet_trivia.util.AppColors
import com.example.jetpacklearning_kotlin.weather.navigation.WeatherScreens
import kotlinx.coroutines.delay

@Composable
fun WeatherSplashScreen(navController: NavController)
{
    val scale= remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true, block = {
        scale.animateTo(targetValue = 0.9f, animationSpec = tween(durationMillis = 800, easing = {
            OvershootInterpolator(8f)
                .getInterpolation(it)
        }))
        delay(2000L)
        navController.navigate(WeatherScreens.MainScreen.name)
    })

    Surface(modifier = Modifier
        .padding(15.dp)
        .size(330.dp)
        .scale(scale.value),
        shape = CircleShape,
        color= Color.White,
        border = BorderStroke(width = 2.dp, color = Color.LightGray))
    {
        Column(modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)
        {
            Image(painter = painterResource(id = R.drawable.sun), contentDescription = "this is me",
                modifier =Modifier.size(95.dp))
            Text(text = "Find The Sun?", style = MaterialTheme.typography.h5,
                color=AppColors.mLightGray)
        }
    }
}