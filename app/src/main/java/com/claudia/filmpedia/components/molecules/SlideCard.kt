package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.claudia.filmpedia.components.atoms.BorderNumber
import com.claudia.filmpedia.components.atoms.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.claudia.filmpedia.domain.Movie

@Composable
fun SlideCard(movie:Movie, number:Int, onClick:()->Unit){
    Spacer(modifier = Modifier.width(16.dp))
    Box(modifier = Modifier.fillMaxWidth().clickable (onClick=onClick ) ) {
        Image(imageurl = movie.imageUrl, height = 230.dp, width = 180.dp)
        Box(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            BorderNumber(number = number)
        }
    }
}