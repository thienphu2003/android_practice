package com.thienphu.mythirdproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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

@OptIn(ExperimentalMaterial3Api::class)
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

    val myTextFieldValue = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("Result")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.openlayers_static_humanitarian),
            contentDescription = "",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.size(30.dp))
        if (buttonStatus.value == true) {
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
                if (buttonStatus.value == true) {
                    myButtonColor.value = Color.Black
                    myButtonText.value = "Compose is fun"
                    myButtonTextColor.value = Color.Red
                    myText.value = "Hello Compose"
                    myTextValue.value = Color.White
                    buttonStatus.value = false
                } else {
                    myButtonColor.value = Color.Red
                    myButtonText.value = "Do you magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello World"
                    myTextValue.value = Color.Black
                    buttonStatus.value = true
                }
                userInput.value = myTextFieldValue.value
                myTextFieldValue.value = ""
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
        Spacer(modifier = Modifier.size(30.dp))
        TextField(
            value = myTextFieldValue.value,
            onValueChange = {
                myTextFieldValue.value = it
            },
            label = { Text(text = "Enter your name", color = Color.White) },
            modifier = Modifier.width(300.dp),
            textStyle = TextStyle(fontSize = 20.sp, color = Color.White),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Blue,
                focusedLabelColor = Color.Yellow,
                unfocusedLabelColor = Color.White,
                focusedIndicatorColor = Color.Green,
                unfocusedIndicatorColor = Color.Red

            ),
            maxLines = 4,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = PasswordVisualTransformation()


        )
        Spacer(modifier = Modifier.size(30.dp))
        Text(
            text = userInput.value,
            color = myTextValue.value,
            fontSize = 24.sp,
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyThirdProjectTheme {
        Components()
    }
}