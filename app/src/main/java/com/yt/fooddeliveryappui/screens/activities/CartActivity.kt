package com.yt.fooddeliveryappui.screens.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yt.fooddeliveryappui.BaseActivity
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonButton
import com.yt.fooddeliveryappui.commonui.CommonHeader
import com.yt.fooddeliveryappui.commonui.Text15_600
import com.yt.fooddeliveryappui.commonui.Text17_600
import com.yt.fooddeliveryappui.model.Food
import com.yt.fooddeliveryappui.model.listOfFood
import com.yt.fooddeliveryappui.ui.theme.orange

class CartActivity : BaseActivity() {

    @Composable
    override fun Content() {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    CommonHeader(text = "Cart") {
                        finish()
                    }

                    LazyColumn {
                        items(listOfFood) { food ->
                            EachRow(food = food)
                        }
                    }

                }

                CommonButton(
                    text = "Complete Order",
                    foregroundColor = Color.White,
                    backgroundColor = orange
                )
            }
        }
    }

    @Composable
    fun EachRow(
        food: Food
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            elevation = 1.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(modifier = Modifier.background(Color.White)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = food.image), contentDescription = "",
                        modifier = Modifier.size(70.dp)
                    )
                    Column(
                        modifier = Modifier
                            .align(CenterVertically)
                            .padding(start = 10.dp)
                    ) {
                        Text17_600(text = food.name, color = Color.Black)
                        Text15_600(
                            text = "$${food.price}",
                            color = orange,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                }
            }
        }
    }
}
