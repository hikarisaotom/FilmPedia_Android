package com.claudia.filmpedia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.molecules.HorizontalImageList
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.navigation.NavBar.Navbar
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun HomeScreen(movies: LazyPagingItems<Movie>,
               upcoming: LazyPagingItems<Movie>,
               topRated: LazyPagingItems<Movie>,
               nowplaying: LazyPagingItems<Movie>,){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.blue_background))){
        if(movies.loadState.refresh is LoadState.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            Column {
                HorizontalImageList( movies = movies)
                Navbar( upcoming = upcoming,
                    topRated = topRated,
                    nowplaying = nowplaying,)
            }
        }


    }
}
