package com.stormbirdmedia.androidcomposebase.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stormbirdmedia.androidcomposebase.composable.TaskItemLayout
import com.stormbirdmedia.androidcomposebase.composable.TaskTextField
import com.stormbirdmedia.androidcomposebase.composable.TitleComposable
import com.stormbirdmedia.androidcomposebase.composable.rememberEditableUserInputState
import com.stormbirdmedia.androidcomposebase.screen.main.MainViewModel
import com.stormbirdmedia.domain.model.Task
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    goToSecondScreenAction: () -> Unit,
    mainViewModel: MainViewModel = koinViewModel()
) {
    val textFromViewModel = mainViewModel.dataSource.collectAsState()
    val uiState = mainViewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val currentState = uiState.value
        when (currentState) {
            is MainViewModel.MainUiState.Loading -> {

            }
            is MainViewModel.MainUiState.DisplayTasks -> {
                TaskDashboard(
                    currentState.tasks,
                    addNewTask = {
                        mainViewModel.postUiEvent(MainViewModel.MainUiEvent.OnAddTask(it))
                    },
                    onTaskClicked = { },
                    onTaskChecked = {
                        mainViewModel.postUiEvent(MainViewModel.MainUiEvent.OnTaskChecked(it))
                    },
                    onDeleteClicked = {
                        mainViewModel.postUiEvent(
                            MainViewModel.MainUiEvent.OnDeleteTask(
                                it
                            )
                        )
                    }
                )

            }
        }
    }
}

@Composable
fun TaskDashboard(
    taskList: List<Task>,
    addNewTask: (text: String) -> Unit,
    onTaskClicked: () -> Unit,
    onTaskChecked: (task: Task) -> Unit,
    onDeleteClicked: (task: Task) -> Unit
) {
    val editableUserInputState = rememberEditableUserInputState(hint = "")

    Column(
        Modifier
            .padding(8.dp)
    ) {
        TitleComposable(text = "My tasks")
        Spacer(modifier = Modifier.height(16.dp))
        TaskTextField(editableUserInputState) {
            addNewTask(it)
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(taskList) { item ->
                TaskItemLayout(task = item, {
                    onTaskClicked()
                }, {
                    onTaskChecked(item.apply { this.isComplete = !this.isComplete })
                }, {
                    onDeleteClicked(item)
                })
            }
        }
    }
}





