package com.example.jetpacklearning_kotlin.jet_trivia

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
import com.example.jetpacklearning_kotlin.jet_trivia.ui.theme.JetPackLearningKotlinTheme

class JetTriviaActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent()
        {
            JetPackLearningKotlinTheme()
            {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String)
{
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3()
{
    JetPackLearningKotlinTheme()
    {
        Greeting("Android")
    }
}