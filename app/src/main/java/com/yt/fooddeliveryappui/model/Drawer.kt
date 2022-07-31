package com.yt.fooddeliveryappui.model

import com.yt.fooddeliveryappui.R

data class Drawer(
    val icon:Int,
    val name:String
)

val drawerContent = listOf(
    Drawer(
        R.drawable.profile_icon,
        "Profile"
    ),
    Drawer(
        R.drawable.cart_icon,
        "Orders"
    ),
    Drawer(
        R.drawable.offer_icon,
        "offer & promo"
    ),
    Drawer(
        R.drawable.privacy_icon,
        "Privacy policy"
    ),
    Drawer(
        R.drawable.security_icon,
        "Security"
    ),
)