package com.example.lab4.domain

import com.example.lab4.data.entities.TaskEntity
import com.example.lab4.data.repository.TaskRepository
import javax.inject.Inject

class DeleteTaskUseCaseImpl @Inject constructor(
    private val taskRepository: TaskRepository
) : DeleteTaskUseCase {

    override suspend fun invoke(task: TaskEntity) =
        taskRepository.deleteTask(task)
}