package com.claudia.filmpedia.components.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun Image(imageurl:String, height:Dp, width:Dp, padding:Dp = 8.dp){
    SubcomposeAsyncImage(
        model = imageurl,
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = imageurl,
        modifier = Modifier.height(height)
            .width(width).padding(padding).clip(shape = RoundedCornerShape(30.dp)),
        contentScale = ContentScale.Fit,

    )
}