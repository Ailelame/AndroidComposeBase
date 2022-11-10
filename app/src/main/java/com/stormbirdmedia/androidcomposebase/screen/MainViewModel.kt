package com.stormbirdmedia.androidcomposebase.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stormbirdmedia.domain.model.Task
import com.stormbirdmedia.domain.port.api.TaskUseCase
import com.stormbirdmedia.domain.usecase.TaskUseCaseImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val taskUseCase: TaskUseCase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val taskList = MutableStateFlow<List<Task>>(listOf())


    private val _dataSource = MutableStateFlow("")
    val dataSource: StateFlow<String> = _dataSource

    init {
        viewModelScope.launch(defaultDispatcher) {
            delay(3000)
            _dataSource.value = "updated string"

            taskUseCase.getTasks().collect {
                taskList.value = it
            }
        }
    }

    fun addTask(text: String) {
        viewModelScope.launch(defaultDispatcher) {
            taskUseCase.insertTask(text)
        }
    }


//    sealed class MainUIEvent{
//        class
//    }

}