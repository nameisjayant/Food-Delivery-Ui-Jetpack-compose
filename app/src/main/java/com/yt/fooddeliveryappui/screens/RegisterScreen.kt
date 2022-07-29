package com.yt.fooddeliveryappui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonLine
import com.yt.fooddeliveryappui.commonui.NoRippleEffect
import com.yt.fooddeliveryappui.commonui.Text18_600
import com.yt.fooddeliveryappui.ui.theme.lightGray

object RegisterScreen : Screen {

    @Composable
    override fun Content() {

        var track1 by remember { mutableStateOf(true)}
        var track2  by remember { mutableStateOf(false)}

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(lightGray)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .weight(0.5f),
                elevation = 3.dp,
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box{}

                    Icon(painter = painterResource(id = R.drawable.app_icon), contentDescription = "",
                        modifier = Modifier.size(150.dp),
                        tint = Color.Unspecified
                    )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column {
                                Text18_600(text = "Login", color = Color.Black, modifier = Modifier.NoRippleEffect {
                                    if(track1){}
                                    else{
                                        track1 = true
                                        track2 = false
                                    }
                                }.align(CenterHorizontally))
                                if(track1)
                                CommonLine(
                                    height = 1.dp,
                                    width = 80.dp,
                                    modifier = Modifier.padding(top = 5.dp)
                                )
                            }

                            Column() {
                                Text18_600(text = "Sign-Up", color = Color.Black, modifier = Modifier.NoRippleEffect {
                                    if(track2){}
                                    else{
                                        track1 = false
                                        track2 = true
                                    }
                                }.align(CenterHorizontally))
                                if(track2)
                                    CommonLine(
                                        height = 1.dp,
                                        width = 80.dp,
                                        modifier = Modifier.padding(top = 5.dp)
                                    )
                            }
                        }


                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            ) {

            }
        }
    }

}