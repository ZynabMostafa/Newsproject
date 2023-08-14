package com.example.newsproject.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.newsproject.presentation.home.composable.ErrorDialog
import com.example.newsproject.presentation.home.composable.ListScreen
import com.example.newsproject.presentation.home.composable.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel , navController: NavController){
    val state by homeViewModel.status.collectAsState()
    Scaffold (
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
           Button(onClick = { navController.navigate("detail") }) {
               Text(text = "Navigate")
           }
        }
    ){
        ErrorDialog(showDialog =state.dialogModel?.showDialog ?: false,
            massage = state.dialogModel?.massage ?: " no massage",
            onConfirmClic = {
               homeViewModel.dismissDialog()
                homeViewModel.get()
        }) {
            
        }
        Box (modifier = Modifier.padding(it)){
                LoadingScreen(isLoading = state.isLoading , modifier = Modifier.align(Alignment.Center))
            ListScreen(list = state.list, onclick = {article ->
                homeViewModel.insertArticle(article)} )
        }
    }
}