package com.michaelbukachi.koinrobolectric

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger
import org.koin.dsl.module

class KoinRobolectric : Application() {

    override fun onCreate() {
        super.onCreate()
        val dataModule = module {
            single<SomeService> { GoodService() }
        }

        startKoin {
            if (BuildConfig.DEBUG) androidLogger() else EmptyLogger()
            androidContext(this@KoinRobolectric)
            modules(listOf(dataModule))
        }
    }
}