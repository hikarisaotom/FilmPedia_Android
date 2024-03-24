@file:OptIn(ExperimentalFoundationApi::class)

package com.claudia.filmpedia.navigation.NavBar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.claudia.filmpedia.components.template.CustomHorizontalPager
import com.claudia.filmpedia.components.template.CustomTabRow
import com.claudia.filmpedia.domain.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navbar(upcoming: LazyPagingItems<Movie>,
           topRated: LazyPagingItems<Movie>,
           nowplaying: LazyPagingItems<Movie>
) {
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
        TabItem(title="Now playing", items = nowplaying),
        TabItem(title="Upcoming", items = upcoming),
        TabItem(title="Top rated", items = topRated),
    )
    Column(modifier = Modifier.fillMaxSize()) {
        CustomTabRow(selectedTabIndex = selectedTabIndex,
            onTabSelected = { index -> selectedTabIndex = index }, tabItems= tabItems)

        CustomHorizontalPager(pagerState = pagerState, tabItems= tabItems)
    }
}