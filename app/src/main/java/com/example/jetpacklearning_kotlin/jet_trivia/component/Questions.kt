package com.example.jetpacklearning_kotlin.jet_trivia.component

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacklearning_kotlin.jet_trivia.screens.QuestionsViewModel
import com.example.jetpacklearning_kotlin.jet_trivia.util.AppColors

@Composable
fun Questions(viewModel: QuestionsViewModel)
{
    val questions=viewModel.getMyData().value.data?.toMutableList()
    if(viewModel.getMyData().value.loading==true)
    {
        CircularProgressIndicator()
        Log.i("mag2851-loading==>", "true")
    }else
    {
        questions?.forEach {
            Log.i("mag2851-question=>",it.question)
        }
    }
    Log.i("mag2851-questionSize==>",questions?.size.toString())
}

@Preview
@Composable
fun QuestionDisplay()
{
    val pathEffect=PathEffect.dashPathEffect(floatArrayOf(10f,10f), phase = 10f)
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(4.dp),
        color = AppColors.mDarkPurple)
    {
        Column(modifier=Modifier.padding(12.dp),verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start)
        {
            QuestionTracker()
            DrawDottedLine(pathEffect =pathEffect )
        }
    }
}

@Preview
@Composable
fun QuestionTracker(counter:Int=10,outOf:Int=100)
{
    Text(text = buildAnnotatedString()
    {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None))
        {
            withStyle(style = SpanStyle(color = AppColors.mLightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp))
            {
                    append("QUESTION $counter/")
                    withStyle(style = SpanStyle(color = AppColors.mLightGray,
                        fontWeight = FontWeight.Light,
                        fontSize = 17.sp,
                    ))
                    {
                        append("$outOf")
                    }
            }
        }
    }, modifier = Modifier.padding(20.dp))

}

//@Preview
@Composable
fun DrawDottedLine(pathEffect: PathEffect)
{
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(1.dp))
    {
        drawLine(color=AppColors.mLightGray,
            start = Offset(0f,0f),
            end = Offset(size.width,y=0f),
            pathEffect = pathEffect
        )

    }
    

}











