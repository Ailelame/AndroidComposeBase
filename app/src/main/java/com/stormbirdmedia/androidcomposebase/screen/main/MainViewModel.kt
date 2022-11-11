package com.stormbirdmedia.androidcomposebase.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stormbirdmedia.domain.model.Task
import com.stormbirdmedia.domain.port.api.TaskUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val taskUseCase: TaskUseCase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val uiState = MutableStateFlow<MainUiState>(MainUiState.Loading())

    private val _dataSource = MutableStateFlow("")
    val dataSource: StateFlow<String> = _dataSource

    init {
        viewModelScope.launch(defaultDispatcher) {
            taskUseCase.getTasks().collect {
                uiState.value = MainUiState.DisplayTasks(it)
            }
        }
    }

    fun postUiEvent(event: MainUiEvent) {
        when (event) {
            is MainUiEvent.OnAddTask -> addTask(event.name)
            is MainUiEvent.OnTaskChecked -> updateTask(event.task)
            is MainUiEvent.OnDeleteTask -> deleteTask(event.task)
        }
    }

    private fun addTask(text: String) {
        viewModelScope.launch(defaultDispatcher) {
            taskUseCase.insertTask(Task(text = text))
        }
    }

    private fun updateTask(task: Task) {
        viewModelScope.launch(defaultDispatcher) {
            taskUseCase.updateTask(task)
        }
    }

    private fun deleteTask(task : Task) {
        viewModelScope.launch(defaultDispatcher) {
            taskUseCase.deleteTaskById(task.id)
        }
    }


    sealed class MainUiEvent {
        class OnAddTask(val name: String) : MainUiEvent()
        class OnTaskChecked(val task: Task) : MainUiEvent()
        class OnDeleteTask(val task: Task) : MainUiEvent()

    }


    sealed class MainUiState{
        class Loading : MainUiState()
        class DisplayTasks(val tasks : List<Task>): MainUiState()
    }


}