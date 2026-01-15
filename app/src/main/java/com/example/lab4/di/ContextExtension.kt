package com.example.lab4.di

import android.content.Context
import com.example.lab4.MainApp

val Context.appComponent: AppComponent
    get() = when(this) {
        is MainApp -> appComponent
        else -> applicationContext.appComponent
    }