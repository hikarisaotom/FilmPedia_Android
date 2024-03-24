package com.claudia.filmpedia.components.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.claudia.filmpedia.components.molecules.EmptyComponent
import com.claudia.filmpedia.components.molecules.MovieDetailsPreview
import com.claudia.filmpedia.domain.Movie

@Composable

fun MovieDetailList(movieList: LazyPagingItems<Movie>, emptyTitle:String, emptySubtitle:String, emptyImg:Int) {
    Box(modifier = Modifier.fillMaxSize()){
        if(movieList.loadState.refresh is LoadState.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            if(movieList.itemCount<=0){
                EmptyComponent(title = emptyTitle, subtitle = emptySubtitle, image =emptyImg)
            }else{
                LazyColumn() {
                    items(movieList){ movie->
                        if(movie!=null){
                            MovieDetailsPreview(movie=movie)
                        }

                    }
                }
            }

        }
    }
}
