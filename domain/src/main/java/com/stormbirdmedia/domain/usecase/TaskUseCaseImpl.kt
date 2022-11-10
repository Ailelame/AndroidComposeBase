package com.stormbirdmedia.domain.usecase

import com.stormbirdmedia.domain.model.Task
import com.stormbirdmedia.domain.port.api.TaskUseCase
import com.stormbirdmedia.domain.port.spi.TaskSpi
import kotlinx.coroutines.flow.Flow

class TaskUseCaseImpl(private val taskSpi: TaskSpi) : TaskUseCase {
    override suspend fun insertTask(task: String) {
        return taskSpi.insertTask(task)
    }

    override fun getTasks(): Flow<List<Task>> {
        return taskSpi.getTasks()
    }

    override suspend fun deleteTaskById(id: Long) {
        return taskSpi.deleteTaskById(id)
    }
}