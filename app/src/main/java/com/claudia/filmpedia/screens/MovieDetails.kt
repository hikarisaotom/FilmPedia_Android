package com.claudia.filmpedia.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun MovieDetails(navController: NavController, viewModel: MovieViewModel){
    Text(text = "details ${viewModel.currentMovie.collectAsState().value?.title}")
}