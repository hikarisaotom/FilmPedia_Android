package com.claudia.filmpedia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.atoms.InformationItem
import com.claudia.filmpedia.components.molecules.HorizontalImageList
import com.claudia.filmpedia.components.molecules.MovieDetailsPreview
import com.claudia.filmpedia.models.Movie
import com.claudia.filmpedia.navigation.NavBar.Navbar

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.blue_background))){

       Column {
           HorizontalImageList(imageUrls = listOf("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg","https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg","https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"))
            Navbar()
       }

    }
}

@Preview
@Composable
fun previewHome(){
    HomeScreen()
}