@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bottomnavbardemo

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.navigation.BottomTab.BottomBarItem
import com.claudia.filmpedia.navigation.BottomTab.CustomBottomNavController

@Composable
fun MainScreen(
    navController: NavHostController,
    movies: LazyPagingItems<Movie>,
    upcoming: LazyPagingItems<Movie>,
    topRated: LazyPagingItems<Movie>,
    nowplaying: LazyPagingItems<Movie>,
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = movies) {
        if (movies.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error Loading information",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    val screens = listOf(
        BottomBarItem.Home,
        BottomBarItem.Search,
        BottomBarItem.WatchList,
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEachIndexed { index, item ->
                    NavigationBarItem(selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route)
                        },
                        icon = {
                            Icon(
                                imageVector = if (selectedItemIndex == index) item.icon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(text = item.title)
                        }

                    )
                }
            }
        }
    ) {
        CustomBottomNavController(
            navController = navController,
            movies = movies,
            upcoming = upcoming,
            topRated = topRated,
            nowplaying = nowplaying,
        )
    }
}
