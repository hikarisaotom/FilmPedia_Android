package com.claudia.filmpedia.components.molecules
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable

@Composable
fun HorizontalImageList(imageUrls: List<String>) {
    LazyRow {
        items(imageUrls.size) { index ->
            SlideCard(
                imageurl = imageUrls[index],
                number = index+1
            )

        }
    }
}
