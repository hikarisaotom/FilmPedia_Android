package com.claudia.filmpedia.components.template

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.claudia.filmpedia.components.molecules.Page
import com.claudia.filmpedia.navigation.NavBar.TabItem
import com.claudia.filmpedia.presentation.MovieViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomHorizontalPager(
    pagerState: PagerState,
    tabItems: List<TabItem>,
    viewModel: MovieViewModel
) {
   Column() {
       HorizontalPager(
           pageCount = tabItems.size,
           state = pagerState,
           modifier = Modifier
               .fillMaxWidth().padding(start = 10.dp, end = 10.dp)
               .weight(1f)
       ) { index ->

           Page(item = tabItems[index], viewModel=viewModel)
       }
   }
}