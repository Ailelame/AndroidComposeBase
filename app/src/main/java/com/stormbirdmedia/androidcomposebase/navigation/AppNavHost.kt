package com.stormbirdmedia.androidcomposebase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stormbirdmedia.androidcomposebase.screen.MainScreen
import com.stormbirdmedia.androidcomposebase.screen.SecondScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.route,
        modifier = modifier
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

