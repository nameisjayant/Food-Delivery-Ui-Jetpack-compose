package com.yt.fooddeliveryappui.screens.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.yt.fooddeliveryappui.BaseActivity
import com.yt.fooddeliveryappui.commonui.DrawerContent
import com.yt.fooddeliveryappui.model.drawerContent
import com.yt.fooddeliveryappui.screens.bottomNavigation.BottomBar
import com.yt.fooddeliveryappui.screens.bottomNavigation.HomeNavigation
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
        val scaffoldState: ScaffoldState = rememberScaffoldState()
        val navHostController = rememberNavController()
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(lightGray)
        ) {
            Scaffold(
                bottomBar = {
                    BottomBar(navController = navHostController)
                },
                drawerContent = {
                    Spacer(modifier = Modifier.height(20.dp))
                    drawerContent.forEach {
                        DrawerContent(drawer = it, isline = it.name != "Security")
                    }
                },
                scaffoldState = scaffoldState,
                drawerBackgroundColor = orange
                ) {
                HomeNavigation(navHostController = navHostController,scaffoldState)
            }
        }
    }


}