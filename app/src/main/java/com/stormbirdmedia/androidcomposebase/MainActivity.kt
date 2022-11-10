package com.stormbirdmedia.androidcomposebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.stormbirdmedia.androidcomposebase.navigation.AppNavHost
import com.stormbirdmedia.androidcomposebase.ui.theme.AndroidComposeBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeBaseTheme {
                val navController = rememberNavController()
                AppNavHost(navController)
            }
        }
    }
}

