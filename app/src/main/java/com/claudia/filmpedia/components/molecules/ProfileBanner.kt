package com.claudia.filmpedia.components.molecules
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.claudia.filmpedia.components.atoms.CustomYoutubePlayer
import com.claudia.filmpedia.components.atoms.Image

@Composable
fun ProfileBanner(
    imageUrl:String,
    videoUrl:String,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        CustomYoutubePlayer(
            videoId = "kShAS6aafOU",
            lifecycleOwner = LocalLifecycleOwner.current
        )
        Box(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Image(imageurl =imageUrl, height = 200.dp, width = 150.dp, padding = 12.dp)
        }
    }
}
