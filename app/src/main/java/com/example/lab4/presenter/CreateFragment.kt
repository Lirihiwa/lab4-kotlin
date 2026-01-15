package com.example.lab4.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lab4.R
import com.example.lab4.data.entities.TaskEntity
import com.example.lab4.data.entities.TaskStatus
import com.example.lab4.databinding.FragmentCreateBinding
import com.example.lab4.di.ViewModelFactory
import com.example.lab4.di.appComponent
import javax.inject.Inject
import kotlin.getValue

class CreateFragment : Fragment(R.layout.fragment_create) {

    private val args: CreateFragmentArgs by navArgs()

    private val binding: FragmentCreateBinding by viewBinding(
        FragmentCreateBinding::bind
    )

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: TaskViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.load(args.taskId)

        viewModel.currentTask.observe(viewLifecycleOwner) { task ->
            if (task != null) {
                binding.editTextTaskTitle.setText(task.title)
                binding.editTextTaskDescription.setText(task.description)
                binding.buttonCreate.text = getString(R.string.change)
            }
        }

        binding.buttonCreate.setOnClickListener {

            val taskTitle = binding.editTextTaskTitle.text.toString()
            val taskDescription = binding.editTextTaskDescription.text.toString()
            val taskStatus = viewModel.currentTask.value?.status ?: TaskStatus.TODO

            val task = TaskEntity(
                id = args.taskId,
                title = taskTitle,
                description = taskDescription,
                status = taskStatus
            )

            viewModel.save(task)

            findNavController().popBackStack()
        }

        binding.buttonBack.setOnClickListener {

            findNavController().popBackStack()
        }
    }
}