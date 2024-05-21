package com.thienphu.mysecondproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thienphu.mysecondproject.ui.theme.MySecondProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySecondProjectTheme {
                // A surface container using the 'background' color from the theme
                MyAlignment()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Composable
fun MyLayout(name : String){
    Text(
        text = "Hello $name!"
    )
}

@Composable
fun MyAlignment(){
    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hello", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, modifier = Modifier
            .background(
                Color.Red
            )
            .padding(start = 20.dp,end=30.dp), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Android", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, modifier = Modifier
            .background(
                Color.Red
            )
            .width(100.dp), textAlign = TextAlign.Center)
        Text(text = "Kotlin", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, modifier = Modifier
            .background(
                Color.Red
            )
            .width(100.dp), textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySecondProjectTheme {
       MyAlignment()
    }
}