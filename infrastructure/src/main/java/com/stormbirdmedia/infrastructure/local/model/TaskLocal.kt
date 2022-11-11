package com.stormbirdmedia.infrastructure.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.stormbirdmedia.domain.model.Task

@Entity
data class TaskLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "isComplete")
    val isComplete: Boolean
) {
    companion object {
        fun TaskLocal.toTask() = Task(this.id, this.text, this.isComplete)
        fun Task.toTaskLocal() = TaskLocal(this.id, this.text, this.isComplete)

    }
}