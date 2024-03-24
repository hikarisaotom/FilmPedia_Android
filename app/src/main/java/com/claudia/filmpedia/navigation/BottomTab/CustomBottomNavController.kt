package com.claudia.filmpedia.navigation.BottomTab
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.screens.HomeScreen
import com.claudia.filmpedia.screens.Search
import com.claudia.filmpedia.screens.WatchList

@Composable
fun CustomBottomNavController(navController : NavHostController,
                              movies: LazyPagingItems<Movie>,
                              upcoming: LazyPagingItems<Movie>,
                              topRated: LazyPagingItems<Movie>,
                              nowplaying: LazyPagingItems<Movie>,) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItem.Home.route
    ) {
        composable(BottomBarItem.Home.route) {
            HomeScreen( movies = movies,
                upcoming = upcoming,
                topRated = topRated,
                nowplaying = nowplaying,)
        }

        composable(BottomBarItem.Search.route) {
            Search(movies=movies)
        }

        composable(BottomBarItem.WatchList.route) {
            WatchList(movies=movies)
        }
    }
}
