package com.example.lab4.domain

import com.example.lab4.data.entities.TaskEntity
import com.example.lab4.data.repository.TaskRepository
import javax.inject.Inject

class GetTaskUseCaseImpl @Inject constructor(
    private val taskRepository: TaskRepository
) : GetTaskUseCase {

    override suspend fun invoke(taskId: Int): TaskEntity? =
        taskRepository.getTask(taskId)
}