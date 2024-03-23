package com.claudia.filmpedia.components.template

import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import com.claudia.filmpedia.navigation.NavBar.tabItems

@Composable
fun CustomTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        tabItems.forEachIndexed { index, tabItem ->
            com.claudia.filmpedia.components.atoms.Tab(
                selected = index == selectedTabIndex,
                tabItem = tabItem,
                action = { onTabSelected(index) }
            )
        }
    }
}