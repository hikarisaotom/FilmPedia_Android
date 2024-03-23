package com.claudia.filmpedia.components.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import com.claudia.filmpedia.navigation.NavBar.TabItem

@Composable
fun Tab(selected:Boolean, tabItem:TabItem,action:()->Unit){
    androidx.compose.material3.Tab(selected = selected,
        onClick = action,
        text = { Text(text = tabItem.title) })
}