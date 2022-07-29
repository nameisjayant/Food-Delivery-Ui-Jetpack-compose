package com.yt.fooddeliveryappui.commonui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.yt.fooddeliveryappui.ui.theme.Typography
import com.yt.fooddeliveryappui.ui.theme.gray
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange


@Composable
fun Text65_800(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.h1, modifier = modifier)
}

@Composable
fun Text17_600(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.body2, modifier = modifier)
}


@Composable
fun Text18_600(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.body1, modifier = modifier)
}

@Composable
fun Text15_600(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.h3, modifier = modifier)
}

@SuppressLint("UnnecessaryComposedModifier")
@Composable
inline fun Modifier.NoRippleEffect(crossinline onClick:()->Unit)  = composed {
    clickable (
        indication = null,
        interactionSource = remember { MutableInteractionSource()}
    ){
        onClick()
    }
}


@Composable
fun CommonButton(
    text: String,
    foregroundColor: Color = orange,
    backgroundColor: Color = Color.White,
    modifier: Modifier = Modifier,
    onClick:()->Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(30.dp)
    ) {
        Box(
            modifier = modifier
                .background(backgroundColor)
                .clickable {
                    onClick()
                }
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text17_600(
                text = text,
                color = foregroundColor,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    }

}

@Composable
fun CommonLine(
    width:Dp = 0.dp,
    height:Dp = 0.dp,
    modifier: Modifier = Modifier,
    color: Color = orange
) {
    Box(modifier = modifier
        .width(width)
        .height(height)
        .background(color) )
}

@Composable
fun CommonTextField(
    text: MutableState<String>,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    TextField(value = text.value ,
        onValueChange = {
            text.value = it
        },
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = lightGray,
            unfocusedIndicatorColor = gray,
            focusedIndicatorColor = Color.Black,
            textColor = Color.Black
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )

}