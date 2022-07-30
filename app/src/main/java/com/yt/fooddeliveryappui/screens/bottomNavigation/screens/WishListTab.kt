package com.yt.fooddeliveryappui.screens.bottomNavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.yt.fooddeliveryappui.ui.theme.lightGray

object WishListTab : Tab {

    override val options: TabOptions
    @Composable
        get() {
            val title = "WishList"
        val icon = rememberVectorPainter(Icons.Outlined.Favorite)
        return remember {
            TabOptions(
                1u,
                title,
                icon
            )
        }
        }


    @Composable
    override fun Content() {
        Column(
            modifier = Modifier.fillMaxSize().background(lightGray)
        ) {

        }
    }


}