package com.claudia.filmpedia.components.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun Image(imageurl:String){
    SubcomposeAsyncImage(
        model = imageurl,
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = imageurl,
        modifier = Modifier.height(300.dp)
            .width(200.dp) ,
        contentScale = ContentScale.Crop,

    )
}