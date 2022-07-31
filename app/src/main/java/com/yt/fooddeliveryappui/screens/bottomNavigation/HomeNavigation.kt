package com.yt.fooddeliveryappui.screens.bottomNavigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.HistoryTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.HomeTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.ProfileTab
import com.yt.fooddeliveryappui.screens.bottomNavigation.screens.WishListTab


@Composable
fun HomeNavigation(
    navHostController: NavHostController,
    scaffoldState: ScaffoldState
) {

    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route ){
        composable(BottomBarScreen.Home.route){
            HomeTab(scaffoldState)
        }

        composable(BottomBarScreen.Fav.route){
            WishListTab()
        }

        composable(BottomBarScreen.Profile.route){
            ProfileTab(navHostController)
        }

        composable(BottomBarScreen.History.route){
            HistoryTab()
        }
    }

}