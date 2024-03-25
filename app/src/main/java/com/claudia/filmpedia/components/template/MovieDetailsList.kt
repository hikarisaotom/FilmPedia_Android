package com.claudia.filmpedia.components.template

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.claudia.filmpedia.components.molecules.EmptyComponent
import com.claudia.filmpedia.components.molecules.MovieDetailsPreview
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable

fun MovieDetailList(
    viewModel: MovieViewModel,
    onClick: () -> Unit = {},
    movieList: List<Movie>,
    emptyTitle: String,
    emptySubtitle: String,
    emptyImg: Int,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (movieList.isEmpty()) {
            EmptyComponent(title = emptyTitle, subtitle = emptySubtitle, image = emptyImg)
        } else {
            LazyColumn() {
                items(movieList.size) { i ->
                    if (movieList[i] != null) {
                        MovieDetailsPreview(
                            movie = movieList[i],
                            onClick = onClick,
                            viewModel = viewModel
                        )
                    }

                }
            }

        }
    }
}
