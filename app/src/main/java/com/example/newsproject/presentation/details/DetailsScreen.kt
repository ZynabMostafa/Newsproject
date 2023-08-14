package com.example.newsproject.presentation.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.newsproject.presentation.home.composable.ListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen (detailsViewModel: DetailsViewModel , navController: NavController){
       val state by detailsViewModel.state.collectAsState()
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier
                .padding(it)
                .fillMaxSize() ){
                ListScreen(list = state.list, onclick = { article ->
                    val index = state.list.indexOf(article)
                    detailsViewModel.deleteArticle(state.list[index])
                })
                Button(onClick = { detailsViewModel.deleteAll() }, modifier = Modifier.align(
                    Alignment.BottomCenter)) {
                    Text(text = "DeleteAll")
                }
            }
        }
    }
