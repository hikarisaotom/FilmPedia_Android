package com.claudia.filmpedia.components.atoms

import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable

fun InformationItem(text:String, icon:ImageVector, color:Color = Color.Gray){
    Row(modifier = Modifier.padding(8.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color
        )

        Text(
            text = text,
            color = color,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}