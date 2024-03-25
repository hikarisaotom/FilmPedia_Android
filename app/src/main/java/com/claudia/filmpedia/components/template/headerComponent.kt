package com.claudia.filmpedia.components.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.molecules.Header
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.presentation.MovieViewModel
import androidx.compose.material3.Icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderComponent(onClick: () -> Unit,
                    viewModel: MovieViewModel,
                    movies: LazyPagingItems<Movie>,
                    search:Boolean,
                    emptyTitle: String,
                    emptySubtitle: String,
                    emptyImg: Int,
                    ) {
    var searchText by remember {
        mutableStateOf(TextFieldValue(""))
    }

    fun filterResults(): List<Movie> {
        var temp = mutableListOf<Movie>()
        for (i in 0 until movies.itemCount) {
            val title= movies[i]?.title?.lowercase()
            val searchLower= searchText.text.lowercase()
            if (movies[i] != null && !search || (title.equals(searchLower,true) || title?.contains(
                    searchLower ?: ""
                ) == true)
            ) {
                temp.add(movies[i]!!)
            }
        }
        return temp
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue_background))
    ) {
        Column {
            Header(title = "Search", onBackClick = {}, onInfoClick = {}, hideInfo = !search)
           if(search){
              Box(
                  modifier = Modifier
                      .fillMaxWidth()
                      .height(50.dp)
                      .background(colorResource(id = R.color.blue_background))
                      .padding(start = 20.dp, end = 20.dp),
              ) {
                  TextField(
                      value = searchText,
                      onValueChange = { newText ->
                          searchText = newText
                      },
                      placeholder = { Text(text = "Search", color =colorResource(id = R.color.subtitle_text) ) },
                      modifier = Modifier
                          .fillMaxWidth()
                          .height(50.dp)
                          .background(colorResource(id = R.color.search_Input))
                          ,
                      textStyle = TextStyle(color = Color.Black),
                      keyboardOptions = KeyboardOptions(
                          keyboardType = KeyboardType.Text,
                          imeAction = ImeAction.Search
                      ),
                      colors = TextFieldDefaults.textFieldColors(
                          containerColor = colorResource(id = R.color.search_Input),
                          textColor= Color.White,


                      focusedIndicatorColor =  Color.Transparent),
                      trailingIcon = {
                          Icon(Icons.Filled.Search, "", tint = colorResource(id = R.color.subtitle_text) )
                      },
                      singleLine = true,
                      maxLines = 1,
                       shape = RoundedCornerShape(60.dp)
                  )

              }
           }
            Spacer(modifier = Modifier.height(8.dp))
            if (movies.loadState.refresh is LoadState.Loading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                MovieDetailList(
                    movieList = filterResults(),
                    emptyTitle = emptyTitle,
                    emptySubtitle = emptySubtitle,
                    emptyImg = emptyImg,
                    viewModel = viewModel,
                    onClick = onClick,
                )
            }
        }
    }
}
