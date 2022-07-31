package com.yt.fooddeliveryappui.screens.bottomNavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.yt.fooddeliveryappui.commonui.CommonHeader
import com.yt.fooddeliveryappui.commonui.Text17_600
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
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(lightGray)
        ) {
            CommonHeader(text = "My Profile",modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)){
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp)
            ) {
                Text17_600(text = "Information", color = Color.Black)
            }
        }
    }
}