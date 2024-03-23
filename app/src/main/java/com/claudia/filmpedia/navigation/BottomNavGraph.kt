package com.claudia.filmpedia.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.claudia.filmpedia.screens.HomeScreen
import com.claudia.filmpedia.screens.Search
import com.claudia.filmpedia.screens.WatchList

@Composable
fun BottomNavGraph(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }

        composable(BottomBarScreen.Search.route) {
            Search()
        }

        composable(BottomBarScreen.WatchList.route) {
            WatchList()
        }
    }
}
