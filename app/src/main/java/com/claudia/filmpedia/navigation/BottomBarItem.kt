package com.claudia.filmpedia.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(
    val route:String,
    val title: String,
    val icon:ImageVector,
    val unselectedIcon:ImageVector
) {

    object Home: BottomBarItem(
        route = "home",
        title = "home",
        icon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Add
    )
    object Search: BottomBarItem(
        route = "Search",
        title = "Search",
        icon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Add
    )
    object WatchList: BottomBarItem(
        route = "Watchlist",
        title = "Watchlist",
        icon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Add
    )
}