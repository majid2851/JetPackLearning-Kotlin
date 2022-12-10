package com.example.jetpacklearning_kotlin.note_app.screen

import android.os.Build
import android.provider.ContactsContract
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacklearning_kotlin.R
import com.example.jetpacklearning_kotlin.movie_and_bill_app.widgets.IconButtonSizeModifier
import com.example.jetpacklearning_kotlin.note_app.components.NoteButton
import com.example.jetpacklearning_kotlin.note_app.components.NoteInputText
import com.example.jetpacklearning_kotlin.note_app.data.NoteDataSource
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel
import com.example.jetpacklearning_kotlin.note_app.util.formatDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(notes:List<NoteModel>,onAddNote:(NoteModel)->Unit,
                onRemoveNote:(NoteModel) ->Unit)
{
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context= LocalContext.current

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
            NoteInputText( text = title
                , label = "title", onTextChange =
            {

                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    })title =it
            })
            NoteInputText(text = description, label = "Add A Note"
                , onTextChange ={
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        })description =it
                    {

                    }

            })
            NoteButton(text = "Submit", onClick = {
                if(title.isNotEmpty() && description.isNotEmpty())
                {
                    onAddNote(NoteModel(title = title, description = description))
                    title=""
                    description=""
                    Toast.makeText(context,"Note added",Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn()
        {
            items(notes)
            {
                NoteRow(modifier = Modifier, note = it, onNoteClicked = {
                    onRemoveNote(it)
                })
            }

        }

        

    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteRow(modifier: Modifier,note:NoteModel,
            onNoteClicked:(NoteModel)->Unit)
{
    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(), color = Color(0xE7B8C7FD),elevation = 6.dp,)
    {
        Column(
            modifier
                .clickable { onNoteClicked(note)}
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start)
        {
            Text(text = note.title, style = MaterialTheme.typography.subtitle2)
            Text(text = note.description, style = MaterialTheme.typography.subtitle1)
            Text(text = formatDate(note.entryDate.time),
                style = MaterialTheme.typography.caption)

        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun NoteScreenPreview()
{
    NoteScreen(NoteDataSource().loadNotes(),{},{})


}






