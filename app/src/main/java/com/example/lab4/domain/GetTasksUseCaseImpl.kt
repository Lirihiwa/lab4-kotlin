package com.example.lab4.domain

import com.example.lab4.data.entities.TaskEntity
import com.example.lab4.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCaseImpl @Inject constructor(
    private val taskRepository: TaskRepository
) : GetTasksUseCase {

    override fun invoke(): Flow<List<TaskEntity>> =
        taskRepository.getTasks()
}