package com.example.lab4.di

import com.example.lab4.data.repository.TaskRepository
import com.example.lab4.data.repository.TaskRepositoryImpl
import com.example.lab4.domain.DeleteTaskUseCase
import com.example.lab4.domain.DeleteTaskUseCaseImpl
import com.example.lab4.domain.GetTaskUseCase
import com.example.lab4.domain.GetTaskUseCaseImpl
import com.example.lab4.domain.GetTasksUseCase
import com.example.lab4.domain.GetTasksUseCaseImpl
import com.example.lab4.domain.SaveTaskUseCase
import com.example.lab4.domain.SaveTaskUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {

    @Binds
    fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ) : TaskRepository

    @Binds
    fun bindDeleteTaskUseCase(
        impl: DeleteTaskUseCaseImpl
    ) : DeleteTaskUseCase

    @Binds
    fun bindGetTasksUseCase(
        impl: GetTasksUseCaseImpl
    ) : GetTasksUseCase

    @Binds
    fun bindGetTaskUseCase(
        impl: GetTaskUseCaseImpl
    ) : GetTaskUseCase

    @Binds
    fun bindSaveTaskUseCase(
        impl: SaveTaskUseCaseImpl
    ) : SaveTaskUseCase
}