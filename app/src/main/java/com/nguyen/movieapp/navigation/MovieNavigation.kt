package com.nguyen.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nguyen.movieapp.screens.detail.DetailScreen
import com.nguyen.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(route = MovieScreens.HomeScreen.name) {
            HomeScreen(navController)
        }
        // sample detail route: www.google.com/detail-screen/id=34
        composable(
            route = MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}