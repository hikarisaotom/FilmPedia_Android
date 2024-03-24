package com.claudia.filmpedia.navigation.BottomTab
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.presentation.MovieViewModel
import com.claudia.filmpedia.screens.HomeScreen
import com.claudia.filmpedia.screens.MovieDetails
import com.claudia.filmpedia.screens.Search
import com.claudia.filmpedia.screens.WatchList

@Composable
fun CustomBottomNavController(navController : NavHostController,
                              viewModel: MovieViewModel
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItem.Home.route
    ) {
        composable(BottomBarItem.Home.route) {
            HomeScreen(viewModel=viewModel, onClick = {navController.navigate("MovieDetails")})
        }

        composable(BottomBarItem.Search.route) {
            Search(viewModel=viewModel, onClick = {navController.navigate("MovieDetails")})
        }

        composable(BottomBarItem.WatchList.route) {
            WatchList(viewModel=viewModel,onClick = {navController.navigate("MovieDetails")})
        }

        composable("MovieDetails") { MovieDetails(navController=navController , viewModel=viewModel) }
    }
}
