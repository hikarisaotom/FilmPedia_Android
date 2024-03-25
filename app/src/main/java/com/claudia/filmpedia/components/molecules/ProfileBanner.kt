package com.claudia.filmpedia.components.molecules
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.atoms.CustomYoutubePlayer
import com.claudia.filmpedia.components.atoms.Image
import com.claudia.filmpedia.components.atoms.InformationItem
import com.claudia.filmpedia.domain.Movie

@Composable
fun ProfileBanner(
    movie:Movie
) {
    Box(modifier = Modifier.fillMaxWidth()) {
     Row() {
         CustomYoutubePlayer(
             videoId = movie.videoKey,
             lifecycleOwner = LocalLifecycleOwner.current
         )

     }
        Box(modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(bottom = 150.dp, end = 20.dp)

        ) {
            Box(modifier = Modifier
                .background(color = colorResource(id = R.color.search_Input), shape = RoundedCornerShape(16.dp))) {
                InformationItem(icon = Icons.Outlined.Star, text = movie.rate.toString(), color = colorResource(
                    id = R.color.orange
                ))
            }
        }
        Row(
            modifier = Modifier
                .padding(start = 9.dp, top = 150.dp)
                .align(Alignment.BottomStart)

        ) {
            Image(imageurl =movie.imageUrl, height = 200.dp, width = 150.dp, padding = 12.dp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = movie.title,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(top = 30.dp))

        }
    }
}