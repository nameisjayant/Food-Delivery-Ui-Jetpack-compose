package com.yt.fooddeliveryappui.screens.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.yt.fooddeliveryappui.BaseActivity
import com.yt.fooddeliveryappui.commonui.DrawerContent
import com.yt.fooddeliveryappui.model.drawerContent
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.HistoryTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.HomeTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.ProfileTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.WishListTab
import com.yt.fooddeliveryappui.ui.theme.gray
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange
import kotlinx.parcelize.RawValue

class HomeActivity : BaseActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    override fun Content() {
        val scaffoldState:  ScaffoldState = rememberScaffoldState()
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(lightGray)
        ) {
            TabNavigator(tab = HomeTab) {
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = lightGray,
                            elevation = 0.dp
                        ) {
                            BottomTabItems(tab = HomeTab)
                            BottomTabItems(tab = WishListTab)
                            BottomTabItems(tab = ProfileTab)
                            BottomTabItems(tab = HistoryTab)
                        }
                    },
                    scaffoldState = scaffoldState,
                    drawerContent = {

                        drawerContent.forEach {
                            DrawerContent(drawer = it, isline = it.name != "Security")
                        }

                    },
                    drawerGesturesEnabled = false,
                    drawerBackgroundColor = orange
                ) {
                    CurrentTab()
                }
            }
        }
    }

    @Composable
    fun RowScope.BottomTabItems(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        BottomNavigationItem(selected = tabNavigator.current == tab,
            onClick = {
                tabNavigator.current = tab
            }, icon = { Icon(painter = tab.options.icon!!, contentDescription = "") },
            selectedContentColor = orange,
            unselectedContentColor = gray
        )
    }
}