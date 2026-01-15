package com.example.lab4

import android.app.Application
import com.example.lab4.di.AppComponent
import com.example.lab4.di.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }
}