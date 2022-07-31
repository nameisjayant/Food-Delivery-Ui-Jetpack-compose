package com.yt.fooddeliveryappui.model

import com.yt.fooddeliveryappui.R

data class Payment(
    val name: String,
    val image: Int
)

val paymentDetails = arrayOf(
    Payment(
        "Card",
        R.drawable.card
    ),
    Payment(
        "Bank Account",
        R.drawable.bank,
    ),
    Payment(
        "Paypal",
        R.drawable.paypal
    )
)
