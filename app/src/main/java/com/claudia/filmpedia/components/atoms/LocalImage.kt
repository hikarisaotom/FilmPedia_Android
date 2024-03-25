package com.claudia.filmpedia.components.atoms
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LocalImage(imageResId: Int) {
    androidx.compose.foundation.Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier.height(200.dp)
            .width(300.dp).padding(8.dp),
        contentScale = ContentScale.Fit,

    )
}