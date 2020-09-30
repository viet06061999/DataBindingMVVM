package com.example.databindingmvvm

import android.app.Application
import com.example.databindingmvvm.di.apiModule
import com.example.databindingmvvm.di.repositoryModule
import com.example.databindingmvvm.di.retrofitModule
import com.example.databindingmvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}