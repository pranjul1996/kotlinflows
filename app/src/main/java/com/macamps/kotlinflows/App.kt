package com.macamps.kotlinflows

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        val Context.context: App
            get() = applicationContext as App

        lateinit var instance: App
    }
}