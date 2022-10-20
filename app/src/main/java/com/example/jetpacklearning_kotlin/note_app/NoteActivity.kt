package com.example.jetpacklearning_kotlin.note_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpacklearning_kotlin.note_app.screen.NoteScreen
import com.example.jetpacklearning_kotlin.note_app.ui.theme.JetPackLearningKotlinTheme
import java.io.NotSerializableException

class NoteActivity : ComponentActivity()
{
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




                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2()
{
    JetPackLearningKotlinTheme()
    {

    }
}