package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.claudia.filmpedia.components.atoms.Image

@Composable
fun CustomRowGrid(items: List<String>) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(count = items.size) { index ->
            Image(imageurl = items[index], height = 200.dp, width = 50.dp)
        }
    }
}
