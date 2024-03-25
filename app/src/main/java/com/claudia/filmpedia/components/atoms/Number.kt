package com.claudia.filmpedia.components.atoms

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.claudia.filmpedia.R

@OptIn(ExperimentalTextApi::class)
@Composable
fun BorderNumber(number: Int) {
    Text(
        text = number.toString(),
        modifier=Modifier.padding(start = 18.dp, top = 135.dp),
        style = LocalTextStyle.current.merge(
            TextStyle(color = colorResource(id = R.color.icon_color),
                fontSize = 85.sp,
                drawStyle = Stroke(width = 7f, join = StrokeJoin.Round)
            )
        )
    )
}
