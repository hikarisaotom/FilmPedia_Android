package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun HorizontalImageList(viewModel: MovieViewModel, onClick: () -> Unit) {
    val movies = viewModel.moviePagingFlow.collectAsLazyPagingItems()
        LazyRow (modifier = Modifier.padding(end = 20.dp)){
            items(movies.itemCount) { index ->
                if (movies[index] != null) {
                    SlideCard(
                        movie = movies[index]!!,
                        number = index + 1,
                        onClick = {
                            viewModel.selectMovie(movies[index]!!)
                            onClick()
                        }
                    )
                }

            }
        }

}
