package com.macamps.kotlinflows.base

import android.app.Application
import android.content.Context
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        MobileAds.initialize(this) {}
    }

    companion object {
        val Context.context: App
            get() = applicationContext as App

        lateinit var instance: App
    }
}