package com.stormbirdmedia.androidcomposebase

import android.app.Application
import com.stormbirdmedia.androidcomposebase.di.appModule
import com.stormbirdmedia.androidcomposebase.di.domainModule
import com.stormbirdmedia.androidcomposebase.di.infrastructureModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule, infrastructureModule, domainModule)
        }
    }
}