package com.stormbirdmedia.androidcomposebase.screen.second

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.stormbirdmedia.androidcomposebase.screen.MainScreen
import com.stormbirdmedia.androidcomposebase.ui.theme.AndroidComposeBaseTheme

@Composable
fun SecondScreen(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    AndroidComposeBaseTheme {
        SecondScreen("2nd screen")
    }
}

@Preview()
@Composable
fun MainScreenPreview() {
    AndroidComposeBaseTheme {
        MainScreen({})
    }
}
