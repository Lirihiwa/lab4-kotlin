package com.example.lab4.domain

import com.example.lab4.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

interface GetTasksUseCase {

    operator fun invoke(): Flow<List<TaskEntity>>
}