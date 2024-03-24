package com.claudia.filmpedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.claudia.filmpedia.components.atoms.CustomYoutubePlayer
import com.claudia.filmpedia.presentation.MovieViewModel
import com.claudia.filmpedia.ui.theme.FilmPediaTheme
import com.example.bottomnavbardemo.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FilmPediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.blue_background)
                ) {
                    val viewModel = hiltViewModel<MovieViewModel>()
                    MainScreen(navController=navController,viewModel= viewModel)
                }
            }
        }
    }
}