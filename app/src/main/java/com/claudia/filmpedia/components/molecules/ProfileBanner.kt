package com.claudia.filmpedia.components.molecules
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.claudia.filmpedia.components.atoms.BorderNumber
import com.claudia.filmpedia.components.atoms.Image

@Composable
fun ProfileBanner(
    imageUrl:String,
    videoUrl:String,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(imageurl =videoUrl, height = 300.dp, width = 500.dp)
        Box(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Image(imageurl =imageUrl, height = 200.dp, width = 150.dp, padding = 12.dp)
        }
    }
}
