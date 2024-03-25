package com.claudia.filmpedia.components.template

import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.claudia.filmpedia.R
import com.claudia.filmpedia.navigation.NavBar.TabItem

@Composable
fun CustomTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    tabItems:List<TabItem>
) {
    TabRow(selectedTabIndex = selectedTabIndex,
        containerColor = colorResource(id = R.color.blue_background)
    ) {
        tabItems.forEachIndexed { index, tabItem ->
            com.claudia.filmpedia.components.atoms.Tab(
                selected = index == selectedTabIndex,
                tabItem = tabItem,
                action = { onTabSelected(index) }
            )
        }
    }
}