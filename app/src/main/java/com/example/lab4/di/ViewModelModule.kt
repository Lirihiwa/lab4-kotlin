package com.example.lab4.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab4.presenter.TaskViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(
        factory: ViewModelFactory
    ) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TaskViewModel::class)
    fun bindViewModel(
        viewModel: TaskViewModel
    ) : ViewModel
}