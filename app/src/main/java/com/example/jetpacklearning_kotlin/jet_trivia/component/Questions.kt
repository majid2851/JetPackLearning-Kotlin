package com.example.jetpacklearning_kotlin.jet_trivia.component

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.example.jetpacklearning_kotlin.jet_trivia.model.QuestionModelItem
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
        if (questions!=null)
        {
            QuestionDisplay(question = questions.first())
            {

            }
        }
    }
    Log.i("mag2851-questionSize==>",questions?.size.toString())
}

//@Preview
@Composable
fun QuestionDisplay(
    question:QuestionModelItem,
//    questionIndex:MutableState<Int>,
//    viewModel: QuestionsViewModel,
    onNextClick:(Int)->Unit={}
    )
{
    val choicesState= remember(question) {
        question.choices.toMutableList()
    }
    val answerState= remember(question)
    {
        mutableStateOf<Int?>(null)
    }
    val correctAnswerState= remember(question) {
        mutableStateOf<Boolean?>(null)
    }
    val updateAnswer:(Int) ->Unit= remember(question)
    {
        {
            answerState.value=it
            correctAnswerState.value=(choicesState[it]==question.answer)
        }
    }
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
            QuestionTitle(question)
            choicesState.forEachIndexed { index, answer ->
                Row(modifier= Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .height(45.dp)
                    .border(
                        width = 4.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                AppColors.mOffDarkPurple,
                                AppColors.mOffDarkPurple
                            )
                        ), shape = RoundedCornerShape(15.dp)
                    )
                    .clip(
                        RoundedCornerShape(
                            50, 50,
                            50, 50
                        )
                    )//??????what is clip
                    .background(Color.Transparent))
                {
                    RadioButton(selected =(answerState.value==index),
                        onClick = {
                            updateAnswer(index)
                        }, modifier = Modifier.padding(start = 16.dp),
                    colors = RadioButtonDefaults.colors(
                        selectedColor =
                        if (correctAnswerState.value==true && index==answerState.value)
                        {
                            Color.Green.copy(alpha = .2f)
                        }else
                        {
                            Color.Red.copy(alpha = .2f)
                        }
                    ))
                    Text(text = answer)
                    
                }
            }


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
//@Preview
@Composable
fun QuestionTitle(question:QuestionModelItem)
{
    Column()
    {
        Text(text = question.question,
            modifier = Modifier
                .padding(4.dp)
                .align(alignment = Alignment.Start)
                .fillMaxHeight(.2f),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 22.sp,
            color =AppColors.mOffWhite
            )



    }



}











