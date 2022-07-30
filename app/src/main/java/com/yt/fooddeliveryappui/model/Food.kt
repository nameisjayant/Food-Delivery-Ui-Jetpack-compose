package com.yt.fooddeliveryappui.model

import com.yt.fooddeliveryappui.R

data class Food(
    val name:String,
    val price:Int,
    val info:String,
    val returnPolicy:String,
    val image:Int,
    val listOFImages:List<Int>
)

val listOfFood = listOf(
    Food(
        "Veggie\ntomato mix",
        900,
        "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm",
        "All our foods are double checked before leaving our stores so by any case you found a broken food please contact our hotline immediately.",
        R.drawable.food,
        listOf(
            R.drawable.food,
            R.drawable.food,
            R.drawable.food
        )
    )
)