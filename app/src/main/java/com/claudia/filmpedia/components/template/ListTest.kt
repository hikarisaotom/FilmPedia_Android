package com.claudia.filmpedia.components.template

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.claudia.filmpedia.components.molecules.MovieDetailsPreview
import com.claudia.filmpedia.domain.Movie

@Composable
fun MovieTestList(movies:LazyPagingItems<Movie>){
    val context = LocalContext.current
    LaunchedEffect(key1 = movies){
        if (movies.loadState.refresh is LoadState.Error){
            Toast.makeText(context,
                "Error Loading information",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    Box(modifier = Modifier.fillMaxSize()){
        if(movies.loadState.refresh is LoadState.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            LazyColumn() {
               items(movies){ movie->
                   if(movie!=null){
                       Text(text = movie.title)
                   }
                   
               }
            }
        }
    }
}