package com.thienphu.mythirdproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thienphu.mythirdproject.ui.theme.MyThirdProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyThirdProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Components()
                }
            }
        }
    }
}

@Composable
fun Components() {

    val myButtonColor = remember {
        mutableStateOf(Color.Red)
    }
    val myButtonText = remember {
        mutableStateOf("Do your magic")
    }
    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }

    val myText = remember {
        mutableStateOf("Hello World")
    }
    val myTextValue = remember {
        mutableStateOf(Color.Black)
    }
    val buttonStatus = remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(buttonStatus.value == true){
            Text(
                text = myText.value,
                color = myTextValue.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = {
                if(buttonStatus.value == true){
                    myButtonColor.value = Color.Black
                    myButtonText.value = "Compose is fun"
                    myButtonTextColor.value = Color.Red
                    myText.value = "Hello Compose"
                    myTextValue.value = Color.White
                    buttonStatus.value = false
                }else {
                    myButtonColor.value = Color.Red
                    myButtonText.value = "Do you magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello World"
                    myTextValue.value = Color.Black
                    buttonStatus.value = true
                }
            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(myButtonColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyThirdProjectTheme {
        Components()
    }
}