package com.yt.fooddeliveryappui.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast


fun Context.showMsg(
    msg: String,
    duration: Int = Toast.LENGTH_SHORT
) = Toast.makeText(this, msg, duration).show()


inline fun <reified T> Context.createIntent() = Intent(this, T::class.java)

inline fun <reified T> Context.launchActivity(
    noinline bundle:Intent.()->Unit
) {
    val intent = createIntent<T>()
    intent.bundle()
    startActivity(intent)
}