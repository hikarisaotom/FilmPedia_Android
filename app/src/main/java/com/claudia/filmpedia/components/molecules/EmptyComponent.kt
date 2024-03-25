package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.claudia.filmpedia.components.atoms.LocalImage
import com.claudia.filmpedia.components.atoms.SubTitle
import com.claudia.filmpedia.components.atoms.Title

@Composable
fun EmptyComponent(title:String, subtitle:String, image: Int){
    Box(
        modifier = Modifier.fillMaxSize().padding(start =40.dp, end = 40.dp),
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