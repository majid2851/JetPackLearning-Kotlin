package com.example.jetpacklearning_kotlin.note_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacklearning_kotlin.R
import com.example.jetpacklearning_kotlin.movie_and_bill_app.widgets.IconButtonSizeModifier
import com.example.jetpacklearning_kotlin.note_app.components.NoteInputText

@Composable
fun NoteScreen()
{
    var title by remember {
        mutableStateOf("")
    }



    Column(modifier=Modifier.padding(6.dp))
    {
        TopAppBar(
            title =
            {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions =
            {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "")
            }, backgroundColor = Color(0x65D1CACA)
        )
        //---------------------------
        Column(modifier=Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally)
        {
            NoteInputText(text = "majid", label = "my edi", onTextChange ={

            } )


        }


    }




}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview()
{
    NoteScreen()


}






