package com.claudia.filmpedia.navigation.NavBar

import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.domain.Movie

data class TabItem(
    val title: String,
    val items:LazyPagingItems<Movie>,
)

