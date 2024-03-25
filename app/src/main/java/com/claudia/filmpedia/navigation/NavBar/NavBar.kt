@file:OptIn(ExperimentalFoundationApi::class)

package com.claudia.filmpedia.navigation.NavBar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.claudia.filmpedia.components.template.CustomHorizontalPager
import com.claudia.filmpedia.components.template.CustomTabRow
import com.claudia.filmpedia.domain.Movie
import com.claudia.filmpedia.presentation.MovieViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navbar(onClick:()->Unit, viewModel: MovieViewModel
) {
    val upcoming= viewModel.upComingPagingFlow.collectAsLazyPagingItems()
    val topRated= viewModel.topRatedPagingFlow.collectAsLazyPagingItems()
    val nowplaying= viewModel.nowPlayingPagingFlow.collectAsLazyPagingItems()
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    var pagerState = rememberPagerState(initialPage = 0)
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }
    val tabItems = listOf(
        TabItem(title="Now playing", items = nowplaying, onClick= onClick),
        TabItem(title="Upcoming", items = upcoming, onClick= onClick),
        TabItem(title="Top rated", items = topRated, onClick= onClick),
    )
    Column(modifier = Modifier.fillMaxSize().padding(bottom = 90.dp)) {
        CustomTabRow(selectedTabIndex = selectedTabIndex,
            onTabSelected = { index -> selectedTabIndex = index }, tabItems= tabItems)

        CustomHorizontalPager(pagerState = pagerState, tabItems= tabItems, viewModel=viewModel)
    }
}