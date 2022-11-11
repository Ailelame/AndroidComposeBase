package com.stormbirdmedia.androidcomposebase.navigation

interface AppDestinations {
    val route: String
}

object MainScreen : AppDestinations {
    override val route: String = "main"
}


object SecondScreen : AppDestinations {
    override val route: String = "second"
}

