package com.nguyen.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nguyen.movieapp.Movie
import com.nguyen.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movies") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray,
                )
            )
        }
    ) { padding ->
        Surface(
            modifier = Modifier.padding(padding),
            color = MaterialTheme.colorScheme.background
        ) {
            MainContent(navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movies: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Happiness",
        "Cross the Line",
        "Be Happy",
        "Happy Feet",
        "Life"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movies) {
                Movie(it) { movie ->
                    navController.navigate(route = MovieScreens.DetailScreen.name + "/$movie")
                }
            }
        }
    }
}
