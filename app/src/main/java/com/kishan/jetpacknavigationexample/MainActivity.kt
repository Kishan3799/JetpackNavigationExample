package com.kishan.jetpacknavigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kishan.jetpacknavigationexample.ui.theme.JetpackNavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackNavigationExampleTheme {
                NavigationScreens()
            }
        }
    }
}

@Composable
fun NavigationScreens() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route,){
        composable(route = Screen.FirstScreen.route){
            FirstScreen(
                navController = navController,
                text = "Home Screen"
            )
        }
        composable(
            route = Screen.SecondScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Kishan Verma"
                    nullable = true
                }
            )
        ){ entry->
            SecondScreen(text = "Second Screen",
                setText = entry.arguments?.getString("name"),
                onclickBack = {
                    navController.navigate(route = Screen.FirstScreen.route){
                        popUpTo(Screen.FirstScreen.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
    }

}