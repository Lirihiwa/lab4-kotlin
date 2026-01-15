package com.example.lab4.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.lab4.data.entities.TaskEntity
import com.example.lab4.data.entities.TaskStatus
import com.example.lab4.domain.DeleteTaskUseCase
import com.example.lab4.domain.GetTaskUseCase
import com.example.lab4.domain.GetTasksUseCase
import com.example.lab4.domain.SaveTaskUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskViewModel @Inject constructor(
    getTasksUseCase: GetTasksUseCase,
    private val saveTaskUseCase: SaveTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase,
) : ViewModel() {

    val tasks: LiveData<List<TaskEntity>> = getTasksUseCase().asLiveData()

    private val _currentTask = MutableLiveData<TaskEntity?>()
    val currentTask: LiveData<TaskEntity?> = _currentTask

    fun load(taskId: Int) {

        if (taskId == 0) {
            _currentTask.value = null
            return
        }

        viewModelScope.launch(Dispatchers.IO) {

            val task = getTaskUseCase(taskId)
            _currentTask.postValue(task)
        }
    }

    fun save(task: TaskEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            saveTaskUseCase(task)
        }
    }

    fun delete(task: TaskEntity) {

        viewModelScope.launch(Dispatchers.IO) {
            deleteTaskUseCase(task)
        }
    }
}