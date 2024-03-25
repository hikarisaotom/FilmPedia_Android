package com.claudia.filmpedia.components.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.claudia.filmpedia.R
import com.claudia.filmpedia.navigation.NavBar.TabItem

@Composable
fun Tab(selected:Boolean, tabItem:TabItem,action:()->Unit){
    androidx.compose.material3.Tab(selected = selected,
        onClick = action,
        text = { Text(text = tabItem.title,
            fontSize = 16.sp,
            fontWeight=FontWeight.Normal,
            color = Color.White) })
}