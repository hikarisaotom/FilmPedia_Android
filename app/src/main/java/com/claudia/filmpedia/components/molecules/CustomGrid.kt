package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.components.atoms.Image
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun CustomRowGrid(items: LazyPagingItems<Movie>, viewModel: MovieViewModel, onClick: () -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(count = if(items.itemCount>1) 6 else items.itemCount) { index ->
            val movie = items[index]
            movie?.let { movieItem ->
                Box(modifier = Modifier.clickable( onClick= {
                    viewModel.selectMovie(movieItem)
                    onClick()})) {
                    Image(imageurl = movieItem.imageUrl ?: "", height = 200.dp, width = 200.dp)
                }
            }
        }
    }
}
