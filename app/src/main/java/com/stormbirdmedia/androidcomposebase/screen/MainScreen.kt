package com.stormbirdmedia.androidcomposebase.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.stormbirdmedia.androidcomposebase.ui.theme.AndroidComposeBaseTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    goToSecondScreenAction: () -> Unit,
    mainViewModel: MainViewModel = koinViewModel()
) {
    val textFromViewModel = mainViewModel.dataSource.collectAsState()
    val list = mainViewModel.taskList.collectAsState()
    
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = textFromViewModel.value)
            FilledTonalButton(onClick = goToSecondScreenAction) {
                Text(text = "Nav")
            }
            FilledTonalButton(onClick = { mainViewModel.addTask("hey") }) {
                Text(text = "Ajouter une info")
            }
            LazyColumn {
                items(list.value) { item ->
                    Text(text = item.text)
                }
            }
        }

    }
}


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

