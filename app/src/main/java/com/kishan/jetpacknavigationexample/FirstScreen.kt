package com.kishan.jetpacknavigationexample

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FirstScreen(
    navController: NavController,
    text:String,
    modifier:Modifier = Modifier
) {
    var settext by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = text,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0148F8),
        )
        Spacer(modifier = modifier.height(20.dp))
        OutlinedTextField(
            value = settext,
            onValueChange = {settext =it}
        )
        Button(onClick = {
            navController.navigate(Screen.SecondScreen.withArgs(settext))
        }) {
            Text(text= "Send To 2nd Screen")
        }
    }
}


@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen(text = "Home Screen", navController = rememberNavController())
}