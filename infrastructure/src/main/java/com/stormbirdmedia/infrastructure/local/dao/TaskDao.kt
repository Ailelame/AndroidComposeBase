package com.stormbirdmedia.infrastructure.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stormbirdmedia.infrastructure.local.base.BaseDao
import com.stormbirdmedia.infrastructure.local.model.TaskLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao : BaseDao<TaskLocal> {
    @Query("SELECT * FROM tasklocal")
    fun getAll(): Flow<List<TaskLocal>>

    @Query("DELETE FROM tasklocal WHERE id = :id")
    suspend fun deleteTaskById(id: Long)

}