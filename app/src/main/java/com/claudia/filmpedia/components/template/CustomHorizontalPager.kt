package com.claudia.filmpedia.components.template

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import com.claudia.filmpedia.navigation.NavBar.tabItems
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.claudia.filmpedia.components.molecules.Page
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomHorizontalPager(
    pagerState: PagerState
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