package com.stormbirdmedia.infrastructure.local.provider

import com.stormbirdmedia.domain.model.Task
import com.stormbirdmedia.domain.port.spi.TaskSpi
import com.stormbirdmedia.infrastructure.local.dao.TaskDao
import com.stormbirdmedia.infrastructure.local.model.TaskLocal
import com.stormbirdmedia.infrastructure.local.model.TaskLocal.Companion.toTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskProvider(private val taskDao: TaskDao) : TaskSpi {
    override suspend fun insertTask(task: String) {
        taskDao.insert(TaskLocal(text = task))
    }

    override fun getTasks(): Flow<List<Task>> {
       return taskDao.getAll().map { it.map { it.toTask() } }
    }

    override suspend fun deleteTaskById(id: Long) {
        taskDao.deleteTaskById(id)
    }
}