package com.example.lab4.presenter.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.lab4.data.entities.TaskEntity

class TaskDiffCallback : DiffUtil.ItemCallback<TaskEntity>() {

    override fun areItemsTheSame(
        oldItem: TaskEntity,
        newItem: TaskEntity
    ): Boolean {

        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: TaskEntity,
        newItem: TaskEntity
    ): Boolean {

        return oldItem == newItem
    }

}