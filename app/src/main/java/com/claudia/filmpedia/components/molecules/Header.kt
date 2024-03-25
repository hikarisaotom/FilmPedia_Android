package com.claudia.filmpedia.components.molecules

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.claudia.filmpedia.R

@Composable
fun Header(
    title: String,
    onBackClick: () -> Unit,
    onInfoClick: () -> Unit,
    hideInfo: Boolean = false,
    isInWatchList: Boolean = false,
    isWatchList: Boolean = false
) {
    val context = LocalContext.current
    val message =
        if (isInWatchList) stringResource(id = R.string.removed) else stringResource(id = R.string.added)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = Color.White,
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
        IconButton(onClick = {
            onInfoClick()
            Toast.makeText(
                context,
                message,
                Toast.LENGTH_LONG
            ).show()
        }) {
            val icon = if (isWatchList) {
                if (isInWatchList) Icons.Outlined.Favorite else Icons.Filled.FavoriteBorder
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
