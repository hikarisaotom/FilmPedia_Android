package com.claudia.filmpedia.navigation.NavBar

data class TabItem(
    val title: String,
)

val tabItems = listOf(
    TabItem(title="Now playing"),
    TabItem(title="Upcoming"),
    TabItem(title="Top rated"),
)