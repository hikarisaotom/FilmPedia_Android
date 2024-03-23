package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomRowGrid(items: List<String>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(count = items.size) { item ->
            Text(text = item.toString())
        }
    }
}

@Preview
@Composable
fun PreviewCustomRowGrid() {
    val items = listOf("Movie 1","Movie 2","Movie 3","Movie 4","Movie 5","Movie 6")
    CustomRowGrid(items = items)
}
