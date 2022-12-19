package com.example.jetpacklearning_kotlin.jet_trivia

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacklearning_kotlin.jet_trivia.screens.QuestionsViewModel
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
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                    TrivialHome()
                }
            }
        }
    }
}

@Composable
fun TrivialHome(viewModel:QuestionsViewModel = viewModel())
/*viewModel:QuestionsViewModel=hiltViewModel() ???????????????????????????????????????????????????*/
{
    Questions(viewModel)



}

@Composable
fun Questions(viewModel: QuestionsViewModel)
{
    val questions=viewModel.getMyData().value.data?.toMutableList()
    if(viewModel.getMyData().value.loading==true) {
        Log.i("mag2851-loading==>", "true")
    }else
    {
        questions?.forEach {
            Log.i("mag2851-question=>",it.question)
        }
    }

    Log.i("mag2851-questionSize==>",questions?.size.toString())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3()
{
    JetPackLearningKotlinTheme()
    {

    }
}