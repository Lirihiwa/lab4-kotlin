package com.example.lab4.domain

import com.example.lab4.data.entities.TaskEntity

interface GetTaskUseCase {

    suspend operator fun invoke(taskId: Int): TaskEntity?
}