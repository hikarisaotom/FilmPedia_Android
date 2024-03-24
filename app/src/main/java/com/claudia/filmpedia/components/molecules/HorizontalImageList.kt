package com.claudia.filmpedia.components.molecules
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.domain.Movie

@Composable
fun HorizontalImageList(movies: LazyPagingItems<Movie>, onClick:()->Unit) {
    LazyRow {
        items(movies.itemCount) { index ->
           if(movies[index]!=null){
               SlideCard(
                   movie = movies[index]!!,
                   number = index+1
               )
           }

        }
    }
}
