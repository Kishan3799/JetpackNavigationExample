package com.kishan.jetpacknavigationexample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    text:String,
    setText:String?,
    onclickBack:()-> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = text,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE01515),
            modifier = modifier.clickable { onclickBack() }
        )
        Spacer(modifier = modifier.height(20.dp))
        Text(text = "Hello, $setText",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF092F3E)
        )
    }

}


@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen(text = "Second Screen", onclickBack = {}, setText = "hello")
}