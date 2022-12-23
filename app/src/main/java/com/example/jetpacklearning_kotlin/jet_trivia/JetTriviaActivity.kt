package com.example.jetpacklearning_kotlin.jet_trivia

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacklearning_kotlin.jet_trivia.screens.QuestionsViewModel
import com.example.jetpacklearning_kotlin.jet_trivia.screens.TrivialHome
import com.example.jetpacklearning_kotlin.jet_trivia.ui.theme.JetPackLearningKotlinTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.math.log

@AndroidEntryPoint
class JetTriviaActivity : ComponentActivity()
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
                    TrivialHome()
                }
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun DefaultPreview3()
{
    JetPackLearningKotlinTheme()
    {

    }
}