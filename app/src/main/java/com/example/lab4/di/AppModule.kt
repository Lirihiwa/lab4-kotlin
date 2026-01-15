package com.example.lab4.di

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        DataModule::class,
        AppBindsModule::class,
    ]
)
class AppModule