package com.example.newsproject.presentation.home.composable

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingScreen(isLoading:Boolean , modifier: Modifier = Modifier){
     if (isLoading)  return
    CircularProgressIndicator(color = Color.Blue  , strokeWidth = 20.dp )
}