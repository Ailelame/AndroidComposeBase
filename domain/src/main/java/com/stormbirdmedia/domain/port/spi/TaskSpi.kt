package com.stormbirdmedia.domain.port.spi

import com.stormbirdmedia.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskSpi {
    suspend fun insertTask(task: String)
    fun getTasks(): Flow<List<Task>>
    suspend fun deleteTaskById(id: Long)
}