package com.example.lab4.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab4.data.entities.TaskStatus

@Entity(tableName = TaskEntity.TABLE_NAME)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val status: TaskStatus,
) {

    companion object {
        const val TABLE_NAME = "Tasks"
    }
}