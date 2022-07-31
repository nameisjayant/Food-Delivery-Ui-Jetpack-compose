package com.yt.fooddeliveryappui.screens.bottomNavigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.*
import com.yt.fooddeliveryappui.model.paymentDetails
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange
import com.yt.fooddeliveryappui.ui.theme.textColor1

@Composable
fun ProfileTab(
    navHostController: NavHostController
) {

    var paymentState by remember { mutableStateOf("Card") }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(lightGray),
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(lightGray)
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                CommonHeader(
                    text = "My Profile",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    navHostController.navigateUp()
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 10.dp)
                ) {
                    Text17_600(
                        text = "Information",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = 2.dp,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Box(modifier = Modifier.background(Color.White)) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.pic),
                                    contentDescription = "",
                                    modifier = Modifier.size(60.dp)
                                )
                                Column(
                                    modifier = Modifier.padding(start = 20.dp)
                                ) {
                                    Text18_600(text = "Jayant Kumar", color = Color.Black)
                                    Text13_400(text = "jayntkumar99@gmail.com", color = textColor1)
                                    Text13_400(
                                        text = "No 15 uti street off ovie palace road effurun delta state",
                                        color = textColor1
                                    )
                                }
                            }

                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                        .padding(vertical = 20.dp)
                ) {
                    Text17_600(
                        text = "Payment Method",
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 10.dp)
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = 0.dp,
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Box(modifier = Modifier.background(Color.White)) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ) {
                                paymentDetails.forEach {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .NoRippleEffect {
                                                paymentState = it.name
                                            }
                                            .padding(vertical = 10.dp)
                                    ) {
                                        RadioButton(
                                            selected = it.name == paymentState,
                                            onClick = {
                                                paymentState = it.name
                                            }, colors = RadioButtonDefaults.colors(
                                                selectedColor = orange
                                            ), modifier = Modifier.align(CenterVertically)
                                        )
                                        Column {
                                            Row {
                                                Icon(
                                                    painter = painterResource(id = it.image),
                                                    contentDescription = "",
                                                    modifier = Modifier.size(40.dp),
                                                    tint = Color.Unspecified
                                                )
                                                Text17_400(
                                                    text = it.name,
                                                    color = Color.Black,
                                                    modifier = Modifier
                                                        .padding(start = 5.dp)
                                                        .align(CenterVertically)
                                                )
                                            }
                                            if (it.name != "Paypal")
                                                CommonLine(
                                                    color = lightGray,
                                                    height = 1.dp,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(top = 8.dp)
                                                )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            CommonButton(text = "Update", foregroundColor = Color.White, backgroundColor = orange)

        }

    }
}