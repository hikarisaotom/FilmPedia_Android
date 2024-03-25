package com.claudia.filmpedia.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.components.template.MovieDetailList
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.molecules.Header
import com.claudia.filmpedia.components.template.HeaderComponent
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.presentation.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(onClick: () -> Unit, viewModel: MovieViewModel) {
    val movies = viewModel.moviePagingFlow.collectAsLazyPagingItems()
    HeaderComponent(
        movies = movies,
        emptyTitle = stringResource(id = R.string.search_empty_title),
        emptySubtitle = stringResource(id = R.string.search_empty_subtitle),
        emptyImg = R.mipmap.search,
        viewModel = viewModel,
        onClick = onClick,
        search = true
    )

}
