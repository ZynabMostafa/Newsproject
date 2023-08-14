package com.example.newsproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsproject.presentation.details.DetailsScreen
import com.example.newsproject.presentation.details.DetailsViewModel
import com.example.newsproject.presentation.home.HomeScreen
import com.example.newsproject.presentation.home.HomeViewModel
import com.example.newsproject.ui.theme.NewsprojectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsprojectTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            val homeViewModel: HomeViewModel by viewModels()
                            HomeScreen(homeViewModel = homeViewModel, navController = navController)
                        }
                        composable("details") {
                            val detailsViewModel: DetailsViewModel by viewModels()
                            DetailsScreen(
                                detailsViewModel = detailsViewModel,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsprojectTheme {
        Greeting("Android")
    }
}