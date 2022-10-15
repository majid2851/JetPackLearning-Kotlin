package com.example.jetpacklearning_kotlin.widgets

import android.widget.ImageView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.nio.file.Files.size

val IconButtonSizeModifier= Modifier.size(40.dp)
@Composable
fun RoundImageVector(modifier: Modifier=Modifier,imgVector:ImageVector,onClick:()->Unit,
                 tint:Color = Color.Black.copy(alpha = .8f),
                 backgroundColor:Color=MaterialTheme.colors.background,
                elevation:Dp =4.dp,)
{
    Card(modifier = modifier
        .padding(all = 4.dp)
        .clickable {
            onClick.invoke()
        }
        .then(IconButtonSizeModifier), shape = CircleShape,
    backgroundColor = backgroundColor, elevation = 4.dp) {
        Icon(imageVector = imgVector, contentDescription = "+ or - icon",
        tint=tint)


    }



}