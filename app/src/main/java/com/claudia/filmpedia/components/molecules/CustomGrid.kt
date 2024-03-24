package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.components.atoms.Image
import com.claudia.filmpedia.domain.Movie

@Composable
fun CustomRowGrid(items: LazyPagingItems<Movie>
) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(count = items.itemCount) { index ->
            Image(imageurl = items[index]?.imageUrl ?: "", height = 200.dp, width = 50.dp)
        }
    }
}
