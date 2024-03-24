package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.claudia.filmpedia.navigation.NavBar.TabItem

@Composable
fun Page(item:TabItem){
    Box( modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        CustomRowGrid(items = item.items)
    }
}