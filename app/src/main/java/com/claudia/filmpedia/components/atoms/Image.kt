package com.claudia.filmpedia.components.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun Image(imageurl:String, height:Dp, width:Dp){
    SubcomposeAsyncImage(
        model = imageurl,
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = imageurl,
        modifier = Modifier.height(height)
            .width(width) ,
        contentScale = ContentScale.Crop,

    )
}