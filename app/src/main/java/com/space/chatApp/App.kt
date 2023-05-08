package com.space.chatApp

import android.app.Application
import com.space.chatApp.di.dataBaseModule
import com.space.chatApp.di.dataStoreModule
import com.space.chatApp.di.repositoryModule
import com.space.chatApp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                dataBaseModule,
                repositoryModule,
                viewModelModule,
                dataStoreModule
            )
        }
    }
}