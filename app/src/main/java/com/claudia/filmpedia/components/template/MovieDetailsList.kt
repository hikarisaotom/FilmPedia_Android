package com.claudia.filmpedia.components.template

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.claudia.filmpedia.components.molecules.EmptyComponent
import com.claudia.filmpedia.components.molecules.MovieDetailsPreview
import com.claudia.filmpedia.domain.Movie

@Composable
fun MovieDetailList(movieList: List<Movie>, emptyTitle:String, emptySubtitle:String, emptyImg:Int) {
    if(movieList.isEmpty()){
       EmptyComponent(title = emptyTitle, subtitle = emptySubtitle, image =emptyImg)
    }else{
        LazyColumn() {
            items(count = movieList.size) { index ->
                MovieDetailsPreview(movie = movieList[index])
            }
        }
    }
}
