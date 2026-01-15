package com.example.lab4.data.repository

import com.example.lab4.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getTasks(): Flow<List<TaskEntity>>
    suspend fun getTask(taskId: Int): TaskEntity?
    suspend fun saveTask(task: TaskEntity)
    suspend fun deleteTask(task: TaskEntity)
}