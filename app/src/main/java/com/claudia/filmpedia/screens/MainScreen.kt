@file:OptIn(ExperimentalMaterial3Api::class)
package com.claudia.filmpedia.screens

import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.R
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.navigation.BottomTab.BottomBarItem
import com.claudia.filmpedia.navigation.BottomTab.CustomBottomNavController
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    viewModel: MovieViewModel
) {
    val movies= viewModel.moviePagingFlow.collectAsLazyPagingItems()
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
            NavigationBar(containerColor = colorResource(id = R.color.blue_background)) {
                screens.forEachIndexed { index, item ->
                    NavigationBarItem(selected = index == selectedItemIndex,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.route)
                        },
                        icon = {
                            Icon(
                                imageVector = if (selectedItemIndex == index) item.icon else item.unselectedIcon,
                                tint = if (selectedItemIndex == index) colorResource(id = R.color.icon_color) else Color.White,
                                contentDescription = item.title,
                            )
                        },
                        label = {
                            Text(text = item.title, color = Color.White)
                        }

                    )
                }
            }
        }
    ) {
        CustomBottomNavController(
            viewModel=viewModel,
            navController = navController
        )
    }
}
