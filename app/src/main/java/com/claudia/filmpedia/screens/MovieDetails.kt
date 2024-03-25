package com.claudia.filmpedia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.atoms.InformationItem
import com.claudia.filmpedia.components.molecules.Header
import com.claudia.filmpedia.components.molecules.ProfileBanner
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun MovieDetails(navController: NavController, viewModel: MovieViewModel) {

    val movie = viewModel.currentMovie.collectAsState().value
    val watchListItems = viewModel.watchlistPagingFlow.collectAsLazyPagingItems()

    fun isInside():Boolean{
        for (i in 0 until watchListItems.itemCount) {
            if (watchListItems[i]?.id == movie?.id) {
               return true
            }
        }
        return false
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue_background))
    ) {
        if (movie != null) {
            Column() {
                Header(
                    title = "Detail",
                    onBackClick = { navController.popBackStack() },
                    isInWatchList= isInside(),
                    onInfoClick = {
                        viewModel.toggleWatchList(
                            movie = movie,
                            isInWatchList = isInside()
                        )
                    },
                    isWatchList = true,)
                ProfileBanner(
                    movie = movie
                )
                Column(modifier = Modifier.padding(8.dp)) {
                    Row() {
                        InformationItem(
                            icon = Icons.Outlined.DateRange,
                            text = movie.year.toString()
                        )
                        InformationItem(
                            icon = Icons.Outlined.Face,
                            text = movie.duration.toString()
                        )
                        InformationItem(icon = Icons.Outlined.Info, text = movie.genre.toString())

                    }
                    Text(
                        text = movie.overwiew,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        color = Color.White,
                        fontSize = 22.sp,
                    )
                }
            }
        }
    }
}