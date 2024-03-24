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
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.atoms.InformationItem
import com.claudia.filmpedia.components.molecules.Header
import com.claudia.filmpedia.components.molecules.MovieDetailsPreview
import com.claudia.filmpedia.components.molecules.ProfileBanner
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun MovieDetails(navController: NavController, viewModel: MovieViewModel) {

    val movie = viewModel.currentMovie.collectAsState().value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue_background))
    ) {
        Column() {
            Header(title = "Detail", onBackClick = { navController.popBackStack()}, onInfoClick = { print("adding")})
           if(movie!=null){
               ProfileBanner(imageUrl = movie.imageUrl,
                            videoUrl = movie.imageUrl)
               Row() {
                   InformationItem(icon = Icons.Outlined.DateRange, text = movie.year.toString() )
                   InformationItem(icon = Icons.Outlined.CheckCircle, text = movie.duration.toString() )
                   InformationItem(icon = Icons.Outlined.Info, text = movie.genre.toString() )

               }
               Text(text = movie.overwiew, textAlign = TextAlign.Justify, modifier = Modifier.fillMaxWidth().padding(8.dp),
                   color = Color.White,)
           }
        }
    }
}