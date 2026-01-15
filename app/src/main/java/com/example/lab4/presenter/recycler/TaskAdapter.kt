package com.example.lab4.presenter.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lab4.R
import com.example.lab4.data.entities.TaskEntity
import com.example.lab4.databinding.ItemTaskBinding

class TaskAdapter(
    private val onTaskClick: (task: TaskEntity) -> Unit,
    private val onChangeStatus: (task: TaskEntity) -> Unit,
    private val onDeleteClick: (task: TaskEntity) -> Unit,
) : ListAdapter<TaskEntity, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_task, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {

        val task = getItem(position)
        holder.bind(task)
    }

    inner class TaskViewHolder(
        private val view: View
    ) : RecyclerView.ViewHolder(view) {

        private val binding by viewBinding(
            ItemTaskBinding::bind
        )

        fun bind(task: TaskEntity) {

            with(task) {

                binding.tvTitle.text = title
                binding.tvDescription.text = description
                binding.tvProgress.text = status.toString()
            }

            binding.root.setOnClickListener {
                onTaskClick(task)
            }

            binding.buttonChangeStatus.setOnClickListener {
                onChangeStatus(task)
            }

            binding.buttonDelete.setOnClickListener {
                onDeleteClick(task)
            }
        }
    }
}