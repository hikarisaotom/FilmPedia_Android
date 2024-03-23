@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bottomnavbardemo

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import com.claudia.filmpedia.navigation.BottomBarScreen

@Composable
fun MainScreen() {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.WatchList,
    )
    var selectedItemIndex by rememberSaveable{
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEachIndexed { index, item ->
                    NavigationBarItem(selected = index == selectedItemIndex,
                        onClick = { selectedItemIndex = index
//                                  navController.navigate(item.route)
                                  },
                    icon = {Icon(imageVector = item.icon, contentDescription = item.title)},
                        label = {
                            Text(text = item.title)
                        }

                    )
                }
            }
        }
    ) {

    }
}