package com.stormbirdmedia.androidcomposebase.navigation

import androidx.compose.runtime.Composable
import com.stormbirdmedia.androidcomposebase.screen.MainScreen
import com.stormbirdmedia.androidcomposebase.screen.SecondScreen

interface AppDestinations {
    val route : String
}

object MainScreen : AppDestinations {
    override val route: String = "main"
}


object SecondScreen : AppDestinations {
    override val route: String = "second"
}

