package com.example.jetpacklearning_kotlin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacklearning_kotlin.components.InputField
import com.example.jetpacklearning_kotlin.ui.ui.theme.JetPackLearningKotlinTheme
import com.example.jetpacklearning_kotlin.widgets.RoundImageVector

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content:@Composable ()-> Unit)
{
    JetPackLearningKotlinTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colors.background) {

            content()
        }
    }
}

@Composable
fun TopHeader(totalPerPerson:Double=0.0){
    Surface(color = Color(0xFFF3BBFF), modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape = CircleShape.copy(all = CornerSize(12.dp)))
        //.clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
        ) {
        val total= String.format("%.2f",totalPerPerson)
        Column(modifier=Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Text(text = "Total Each Person", style = MaterialTheme.typography.h5)
            Text(text = "$$total", style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold)

        }

    }

}

@ExperimentalComposeUiApi
@Preview
@Composable
fun MainContent()
{
    val totalState= remember {
        mutableStateOf("")
    }
    val validState= remember(totalState.value) {
        totalState.value.trim().isNotEmpty()
    }
    val sliderPositionState= remember {
        mutableStateOf(0f)
    }
    val counter= remember {
        mutableStateOf(1)
    }

    BillForm(totalState=totalState,validState=validState,
        sliderPositionState=sliderPositionState,counter=counter){

    }

}


@ExperimentalComposeUiApi
@Composable
fun BillForm(modifier: Modifier= Modifier,
            totalState:MutableState<String>,
            validState:Boolean,
             sliderPositionState:MutableState<Float>,
             counter:MutableState<Int>,
            onValChange:(String) ->Unit={}, )
{

    val keyboardController= LocalSoftwareKeyboardController.current

    Column(verticalArrangement = Arrangement.Center,
            modifier= Modifier.padding(5.dp)) {
        TopHeader(134.97)
        Spacer(Modifier.height(10.dp))
        Surface(modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
            .height(height = 300.dp)
            .clip(shape = RoundedCornerShape(CornerSize(12.dp)))
            .border(BorderStroke(2.dp, Color.LightGray)) )
        {
            Column(modifier=Modifier.padding(6.dp) ,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start) {
                InputField(valueState = totalState, labelId = "Enter Bill",
                    enabled = true, isSingleLine = true, onAction = KeyboardActions {
                        if (!validState) return@KeyboardActions
                        onValChange(totalState.value.trim())

                        keyboardController?.hide()

                    })
//            if (validState) {
                Row(
                    modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split", fontSize = 20.sp, modifier = Modifier
                            .align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(120.dp))
                    Row(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        RoundImageVector(imgVector = Icons.Default.Remove, onClick = {
                            if (counter.value>0)
                                counter.value=counter.value-1
                        })
                        Text(
                            text = counter.value.toString(),
                            modifier = Modifier
                                .padding(start = 9.dp, end = 9.dp)
                                .align(Alignment.CenterVertically),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )

                        RoundImageVector(imgVector = Icons.Default.Add, onClick = {
                            counter.value=counter.value+1

                        })
                    }

                }

                Spacer(modifier = Modifier.height(5.dp))

                Row() {
                    Text(text = "Tip",
                        Modifier
                            .align(alignment = Alignment.CenterVertically)
                            .padding(start = 3.dp), fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(190.dp))
                    Text(text = "$33.00", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(5.dp))

                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Row() {
                        Spacer(modifier = Modifier.width(140.dp))
                        Text(text = String.format("%.0f",
                            sliderPositionState.value*100)+"%", fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Slider(value = sliderPositionState.value,
                        onValueChange = {newValue->
                            sliderPositionState.value=newValue
                        },)


                }

//        }

            }



        }
    }



}

