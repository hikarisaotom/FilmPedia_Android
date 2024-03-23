package com.claudia.filmpedia.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(

    val route:String,
    val title: String,
    val icon:ImageVector,
    val unselectedIcon:ImageVector
) {

    object Home: BottomBarScreen(
        route = "home",
        title = "home",
        icon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home
    )
    object Search: BottomBarScreen(
        route = "Search",
        title = "Search",
        icon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home
    )
    object WatchList: BottomBarScreen(
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home
    )
}