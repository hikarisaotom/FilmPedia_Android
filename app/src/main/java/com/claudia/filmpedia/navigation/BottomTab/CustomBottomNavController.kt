package com.claudia.filmpedia.navigation.BottomTab
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.claudia.filmpedia.screens.HomeScreen
import com.claudia.filmpedia.screens.Search
import com.claudia.filmpedia.screens.WatchList

@Composable
fun CustomBottomNavController(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItem.Home.route
    ) {
        composable(BottomBarItem.Home.route) {
            HomeScreen()
        }

        composable(BottomBarItem.Search.route) {
            Search()
        }

        composable(BottomBarItem.WatchList.route) {
            WatchList()
        }
    }
}
