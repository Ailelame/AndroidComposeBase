package com.stormbirdmedia.infrastructure.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stormbirdmedia.infrastructure.local.dao.TaskDao
import com.stormbirdmedia.infrastructure.local.model.TaskLocal


fun buildAppDatabase(applicationContext: Context, databaseName : String): AppDatabase {
    return Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, databaseName
    ).build()
}


@Database(entities = [TaskLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao() : TaskDao
}

