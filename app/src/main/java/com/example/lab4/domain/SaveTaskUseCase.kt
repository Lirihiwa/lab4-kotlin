package com.example.lab4.domain

import com.example.lab4.data.entities.TaskEntity

interface SaveTaskUseCase {

    suspend operator fun invoke(task: TaskEntity)
}