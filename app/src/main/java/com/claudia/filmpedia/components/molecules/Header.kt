package com.claudia.filmpedia.components.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    title: String,
    onBackClick: () -> Unit,
    onInfoClick: () -> Unit,
    hideInfo: Boolean = false,
    isInWatchList: Boolean = false,
    isWatchList: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = title,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,

            )

        Spacer(modifier = Modifier.weight(1f))
        if (!hideInfo) {
            IconButton(onClick = {
                onInfoClick()
            }) {
                val icon = if (isWatchList) {
                    if (isInWatchList == true) Icons.Outlined.Star else Icons.Filled.Add
                } else {
                    Icons.Outlined.Info
                }

                Icon(
                    imageVector = icon,
                    contentDescription = "Info",
                    tint = Color.White
                )

            }
        }

    }
}
