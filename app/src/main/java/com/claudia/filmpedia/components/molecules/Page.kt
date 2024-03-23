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
    val url = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"
    val times = 6
    val urls = mutableListOf<String>()
    repeat(times) {
        urls.add(url)
    }
    Box( modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        CustomRowGrid(items = urls)
    }
}