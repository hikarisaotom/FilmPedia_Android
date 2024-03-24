package com.claudia.filmpedia.components.template

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.claudia.filmpedia.components.molecules.Page
import com.claudia.filmpedia.navigation.NavBar.TabItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomHorizontalPager(
    pagerState: PagerState,
    tabItems: List<TabItem>
) {
   Column() {
       HorizontalPager(
           pageCount = tabItems.size,
           state = pagerState,
           modifier = Modifier
               .fillMaxWidth()
               .weight(1f)
       ) { index ->
           Page(item = tabItems[index])
       }
   }
}