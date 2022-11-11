package com.stormbirdmedia.androidcomposebase.di

import com.stormbirdmedia.domain.port.spi.TaskSpi
import com.stormbirdmedia.infrastructure.local.database.AppDatabase
import com.stormbirdmedia.infrastructure.local.database.buildAppDatabase
import com.stormbirdmedia.infrastructure.local.provider.TaskProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val DATABASE_NAME = "app_database"

val infrastructureModule = module {
    single {
        buildAppDatabase(androidContext(), DATABASE_NAME)
    }
    single {
        get<AppDatabase>().taskDao()
    }

    factory<TaskSpi> {
        TaskProvider(get())
    }
}