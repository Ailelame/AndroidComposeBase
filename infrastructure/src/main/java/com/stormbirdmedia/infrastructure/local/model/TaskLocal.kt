package com.stormbirdmedia.infrastructure.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.stormbirdmedia.domain.model.Task

@Entity
data class TaskLocal(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    @ColumnInfo(name = "text")
    val text : String
) {
    companion object {
        fun TaskLocal.toTask() = Task(this.text)
        fun Task.toTaskLocal() = Task(this.text)

    }
}