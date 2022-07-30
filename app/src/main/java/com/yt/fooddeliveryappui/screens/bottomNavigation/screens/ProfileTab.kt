package com.yt.fooddeliveryappui.screens.bottomNavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.yt.fooddeliveryappui.ui.theme.lightGray

object ProfileTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Profile"
            val icon = rememberVectorPainter(Icons.Outlined.Person)
            return remember {
                TabOptions(
                    2u,
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