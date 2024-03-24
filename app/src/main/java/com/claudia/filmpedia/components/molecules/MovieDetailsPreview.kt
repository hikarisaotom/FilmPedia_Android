package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claudia.filmpedia.components.atoms.Image
import com.claudia.filmpedia.components.atoms.InformationItem
import com.claudia.filmpedia.domain.Movie


@Composable
fun MovieDetailsPreview(movie: Movie){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(Color.DarkGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
     Image(imageurl = movie.imageUrl, height = 200.dp, width =150.dp )
        Spacer(modifier = Modifier.width(0.dp))
        Column(){
            Text(
                text = movie.title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
           InformationItem(text = movie.rate.toString(), icon = Icons.Outlined.Star , color=Color.Yellow)
            InformationItem(text = movie.genre, icon = Icons.Outlined.Info , color=Color.White)
            InformationItem(text = movie.year.toString(), icon = Icons.Outlined.DateRange , color=Color.White)
            InformationItem(text = movie.duration.toString(), icon = Icons.Outlined.Lock , color=Color.White)

        }
    }
}