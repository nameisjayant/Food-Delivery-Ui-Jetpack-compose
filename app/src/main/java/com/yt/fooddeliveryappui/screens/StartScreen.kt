package com.yt.fooddeliveryappui.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonButton
import com.yt.fooddeliveryappui.commonui.Text65_800
import com.yt.fooddeliveryappui.ui.theme.orange

object StartScreen: Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(orange),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.app_icon), contentDescription = "",
                    modifier = Modifier.size(73.dp),
                    tint = Color.Unspecified
                )

                Text65_800(
                    text = "Food For\nEveryone",
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.man_one),
                    contentDescription = "",
                    modifier = Modifier.size(260.dp).offset(x=-(30.dp),y=0.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(id = R.drawable.man_two),
                    contentDescription = "",
                    modifier = Modifier.size(300.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            CommonButton(text = "Get Started"){
                navigator += RegisterScreen
            }

        }
    }
}
}