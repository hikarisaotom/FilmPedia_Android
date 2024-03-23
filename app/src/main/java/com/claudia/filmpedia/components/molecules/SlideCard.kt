package com.claudia.filmpedia.components.molecules

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

@Composable
fun SlideCard(imageurl:String, number:Int){
    Spacer(modifier = Modifier.width(16.dp))
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(imageurl = imageurl, height = 225.dp, width = 150.dp)
        Box(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            BorderNumber(number = number)
        }
    }
}