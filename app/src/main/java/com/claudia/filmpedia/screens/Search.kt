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
import com.claudia.filmpedia.components.template.MovieDetailList
import com.claudia.filmpedia.R
@Composable
fun Search(){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.blue_background))){
        MovieDetailList(movieList = listOf(),
            emptyTitle = stringResource(id = R.string.search_empty_title),
        emptySubtitle = stringResource(id = R.string.search_empty_subtitle),
        emptyImg = R.mipmap.search)
    }
}

@Preview
@Composable
fun previewSeacrh(){
    Search()
}