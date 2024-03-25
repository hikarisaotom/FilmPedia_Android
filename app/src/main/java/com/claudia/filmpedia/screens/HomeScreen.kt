package com.claudia.filmpedia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.R
import com.claudia.filmpedia.components.atoms.RoundedButton
import com.claudia.filmpedia.components.molecules.HorizontalImageList
import com.claudia.filmpedia.navigation.NavBar.Navbar
import com.claudia.filmpedia.presentation.MovieViewModel

@Composable
fun HomeScreen(onClick:()->Unit, redirect:()->Unit,viewModel: MovieViewModel){
    val movies= viewModel.moviePagingFlow.collectAsLazyPagingItems()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.blue_background))){
        if(movies.loadState.refresh is LoadState.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            Column {
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "What do you want to watch?"
                    ,color= Color.White,
                fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                RoundedButton(onClick = redirect)
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalImageList(viewModel=viewModel,onClick=onClick)
                Spacer(modifier = Modifier.height(20.dp))
                Navbar(  viewModel=viewModel,onClick=onClick)
            }

        }


    }
}
