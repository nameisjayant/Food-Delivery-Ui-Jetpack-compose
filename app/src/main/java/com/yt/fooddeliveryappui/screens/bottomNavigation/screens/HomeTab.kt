package com.yt.fooddeliveryappui.screens.bottomNavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.*
import com.yt.fooddeliveryappui.model.listOfFood
import com.yt.fooddeliveryappui.ui.theme.lightGray

object HomeTab : Tab {


    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Outlined.Home)
            return remember {
                TabOptions(
                    0u,
                    title,
                    icon
                )
            }
        }

    @Composable
    override fun Content() {
        val horizontalScrollState = rememberScrollState()
        val verticalScrollState = rememberScrollState()
        val search = remember { mutableStateOf("") }
        val lists by remember { mutableStateOf(listOf("Foods", "Drinks", "Snacks", "Sauce")) }
        var currentListValue by remember { mutableStateOf("Foods") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScrollState)
                .background(lightGray)
                .padding(bottom = 50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CommonIconButton(icon = R.drawable.nav_bar)
                CommonIconButton(icon = R.drawable.cart)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 30.dp)
            ) {
                Text34_700(text = "Delicious\nfood for you", color = Color.Black)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 40.dp)
            ) {
                CommonSearchBar(
                    text = search,
                    isEnabled = false,
                    modifier = Modifier.NoRippleEffect {
                    })
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(horizontalScrollState)
                    .padding(top = 30.dp, bottom = 20.dp, start = 50.dp)
            ) {
                lists.forEach {
                    TabBarListRow(
                        text = it,
                        selected = it == currentListValue,
                    ) {
                        currentListValue = it
                    }
                }
            }

            if (currentListValue == "Foods")
                FoodTabUi()
        }
    }

}

@Composable
fun FoodTabUi() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
    ) {
        items(listOfFood) { food ->
            FoodEachRow(food)
        }
    }
}