package com.example.lab4.di

import android.app.Application
import android.content.Context
import com.example.lab4.presenter.CreateFragment
import com.example.lab4.presenter.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [ AppModule::class ]
)
@Singleton
interface AppComponent {

    fun inject(fragment: MainFragment)
    fun inject(fragment: CreateFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}