package com.stormbirdmedia.infrastructure.local.provider

import com.stormbirdmedia.domain.model.Task
import com.stormbirdmedia.domain.port.spi.TaskSpi
import com.stormbirdmedia.infrastructure.local.dao.TaskDao
import com.stormbirdmedia.infrastructure.local.model.TaskLocal
import com.stormbirdmedia.infrastructure.local.model.TaskLocal.Companion.toTask
import com.stormbirdmedia.infrastructure.local.model.TaskLocal.Companion.toTaskLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskProvider(private val taskDao: TaskDao) : TaskSpi {
    override suspend fun insertTask(task: Task) {
        taskDao.insert(TaskLocal(text = task.text, isComplete = task.isComplete))
    }

    override fun getTasks(): Flow<List<Task>> {
       return taskDao.getAll().map { it.map { it.toTask() } }
    }

    override suspend fun deleteTaskById(id: Long) {
        taskDao.deleteTaskById(id)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.update(task.toTaskLocal())
    }
}