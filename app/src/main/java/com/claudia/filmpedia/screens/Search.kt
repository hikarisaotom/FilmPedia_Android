package com.claudia.filmpedia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.components.template.MovieDetailList
import com.claudia.filmpedia.R
import com.claudia.filmpedia.domain.Movie

@Composable
fun Search(movies: LazyPagingItems<Movie>){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.blue_background))){
        MovieDetailList(movieList = movies,
            emptyTitle = stringResource(id = R.string.search_empty_title),
        emptySubtitle = stringResource(id = R.string.search_empty_subtitle),
        emptyImg = R.mipmap.search)
    }
}