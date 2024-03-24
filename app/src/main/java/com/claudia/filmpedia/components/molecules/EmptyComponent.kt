package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.claudia.filmpedia.components.atoms.LocalImage
import com.claudia.filmpedia.components.atoms.SubTitle
import com.claudia.filmpedia.components.atoms.Title

@Composable
fun EmptyComponent(title:String, subtitle:String, image: Int){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LocalImage(imageResId = image)
            Title(text = title)
            SubTitle(text = subtitle)
        }
    }

}