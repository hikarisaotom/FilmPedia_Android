package com.claudia.filmpedia.components.atoms

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalTextApi::class)
@Composable
fun BorderNumber(number: Int) {
    Text(
        text = number.toString(),
        style = LocalTextStyle.current.merge(
            TextStyle(color = Color.Cyan,
                fontSize = 80.sp,
                drawStyle = Stroke(width = 6f, join = StrokeJoin.Round)
            )
        )
    )
}
