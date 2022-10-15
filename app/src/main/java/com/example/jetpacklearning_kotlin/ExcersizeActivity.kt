package com.example.jetpacklearning_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacklearning_kotlin.ui.theme.JetPackLearningKotlinTheme

class ExcersizeActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent{
            JetPackLearningKotlinTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp()
{
    var moneyCounter = remember {
        mutableStateOf(0)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(), color = Color(0xFF5F0F2F)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            MyMoney(moneyCounter.value)
            Spacer(modifier = Modifier.height(100.dp))
            CreateCircle(moneyCounter.value){newValue->
                moneyCounter.value=newValue
            }
        }


    }
}


@Composable
fun MyMoney(money:Int =100)
{
    Text(text = "$money Million",
        style = TextStyle(color = Color.White, fontSize = 40.sp,
        fontWeight = FontWeight.ExtraBold,)
    )


}

//@Preview
@Composable
fun CreateCircle(moneyCounter: Int=0,updatedMoneyCounter:(Int)->Unit) {
    Card(modifier = Modifier
        .padding(3.dp)
        .size(140.dp)
        .clickable {
            updatedMoneyCounter(moneyCounter+1)
        }
        , shape = CircleShape, elevation = 5.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Click:$moneyCounter", modifier = Modifier,)
        }

        
    }
}





@Preview( showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackLearningKotlinTheme {
        MyApp()
    }
}