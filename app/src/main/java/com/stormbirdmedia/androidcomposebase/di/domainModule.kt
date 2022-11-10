package com.stormbirdmedia.androidcomposebase.di

import com.stormbirdmedia.domain.port.api.TaskUseCase
import com.stormbirdmedia.domain.usecase.TaskUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<TaskUseCase> { TaskUseCaseImpl(get()) }
}