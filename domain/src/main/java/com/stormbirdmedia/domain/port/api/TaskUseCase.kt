package com.stormbirdmedia.domain.port.api

import com.stormbirdmedia.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskUseCase {
    suspend fun insertTask(task : String)
    fun getTasks(): Flow<List<Task>>
    suspend fun deleteTaskById(id: Long)
}