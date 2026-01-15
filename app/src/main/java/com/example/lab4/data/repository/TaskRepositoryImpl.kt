package com.example.lab4.data.repository

import com.example.lab4.data.db.TaskDao
import com.example.lab4.data.entities.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override fun getTasks(): Flow<List<TaskEntity>> =
        taskDao.getAllTasks()

    override suspend fun getTask(taskId: Int): TaskEntity? =
        taskDao.getTaskById(taskId)

    override suspend fun saveTask(task: TaskEntity) {

        if (task.id == 0) {
            taskDao.insertTask(task)
        } else {
            taskDao.updateTask(task)
        }
    }

    override suspend fun deleteTask(task: TaskEntity) =
        taskDao.deleteTask(task)
}