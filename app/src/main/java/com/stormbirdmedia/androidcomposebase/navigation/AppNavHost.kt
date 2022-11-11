package com.stormbirdmedia.androidcomposebase.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stormbirdmedia.androidcomposebase.screen.MainScreen
import com.stormbirdmedia.androidcomposebase.screen.second.SecondScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.route,
        modifier = modifier.padding(16.dp)
    ) {
        composable(route = MainScreen.route) {
            MainScreen(
                goToSecondScreenAction = {
                    navController.navigate(SecondScreen.route)
                }
            )
        }
        composable(route = SecondScreen.route) {
            SecondScreen("2nd")
        }

    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

