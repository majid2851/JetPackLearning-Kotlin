package com.example.jetpacklearning_kotlin.note_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacklearning_kotlin.note_app.data.NoteDataSource
import com.example.jetpacklearning_kotlin.note_app.model.NoteModel
import com.example.jetpacklearning_kotlin.note_app.screen.NoteScreen
import com.example.jetpacklearning_kotlin.note_app.screen.NoteViewModel
import com.example.jetpacklearning_kotlin.note_app.ui.theme.JetPackLearningKotlinTheme
import dagger.hilt.android.AndroidEntryPoint
import java.io.NotSerializableException
import java.time.format.DateTimeFormatter
import kotlin.contracts.ExperimentalContracts

@ExperimentalComposeUiApi
@AndroidEntryPoint
class NoteActivity : ComponentActivity()
{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent()
        {
            JetPackLearningKotlinTheme()
            {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    val viewModel=viewModel<NoteViewModel>()
                    NotesApp(viewModel)

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel= viewModel())
{
    val notesList=noteViewModel.noteList.collectAsState().value

    NoteScreen( notesList,
        onAddNote = {
            noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        })

}




@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview2()
{
    JetPackLearningKotlinTheme()
    {
        NoteScreen(emptyList(),{},{})
    }
}