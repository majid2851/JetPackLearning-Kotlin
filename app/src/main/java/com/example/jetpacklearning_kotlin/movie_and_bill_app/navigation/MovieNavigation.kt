package com.example.jetpacklearning_kotlin.movie_and_bill_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpacklearning_kotlin.movie_and_bill_app.const.Utils
import com.example.jetpacklearning_kotlin.movie_and_bill_app.screens.home.HomeScreen
import com.example.jetpacklearning_kotlin.movie_and_bill_app.screens.details.DetailScreen

@Composable
fun MovieNavigation()
{
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name)
    {
        composable(MovieScreens.HomeScreen.name)
        {
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailsScreen.name+"/{${Utils.MOVIE_NAME}}",
            arguments = listOf(navArgument(name = Utils.MOVIE_NAME)
            {
                type= NavType.StringType
            }))
            {
               DetailScreen(navController = navController,it.arguments?.
                    getString(Utils.MOVIE_NAME))
            }
        
        
    }


}












