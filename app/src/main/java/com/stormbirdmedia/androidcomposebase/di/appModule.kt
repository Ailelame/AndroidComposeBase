package com.stormbirdmedia.androidcomposebase.di

import com.stormbirdmedia.androidcomposebase.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(get())
    }
}