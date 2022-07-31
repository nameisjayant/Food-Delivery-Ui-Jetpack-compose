package com.yt.fooddeliveryappui.screens.activities

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.yt.fooddeliveryappui.BaseActivity
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.*
import com.yt.fooddeliveryappui.model.Food
import com.yt.fooddeliveryappui.model.listOfFood
import com.yt.fooddeliveryappui.ui.theme.lightWhite
import com.yt.fooddeliveryappui.ui.theme.orange
import com.yt.fooddeliveryappui.ui.theme.textGray

class DetailActivity : BaseActivity() {

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    override fun Content() {
        Surface {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(lightWhite)
            ) {
                val data: Food = intent.extras?.getParcelable("data")!!
                item {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, start = 30.dp, end = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CommonIconButton(icon = R.drawable.back) {
                            finish()
                        }
                        CommonIconButton(icon = R.drawable.heart)
                    }

                }

                item {
                    val pager = rememberPagerState(0)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        HorizontalPager(count = data.listOFImages.size, state = pager) { index ->
                            ImagePagerUi(data.listOFImages[index])
                        }

                        HorizontalPagerIndicator(pagerState = pager,
                            activeColor = orange,
                            inactiveColor = orange.copy(alpha = 0.5f)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text28_600(
                            text = data.name,
                            color = Color.Black,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                        Text22_700(text = "$${data.price}", color = orange)
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp, horizontal = 30.dp)
                    ) {
                        Text17_600(text = "Delivery info", color = Color.Black)
                        Text15_400(
                            text = data.info,
                            color = textGray,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 30.dp)
                    ) {
                        Text17_600(text = "Returned Policy", color = Color.Black)
                        Text15_400(
                            text = data.returnPolicy,
                            color = textGray,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(15.dp))
                    CommonButton(
                        text = "Add to cart",
                        backgroundColor = orange,
                        foregroundColor = Color.White
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }


}

@Composable
fun ImagePagerUi(
    image: Int
) {
    Image(
        painter = painterResource(id = image), contentDescription = "",
        modifier = Modifier
            .size(240.dp)
    )
}