package com.example.lab4.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lab4.R
import com.example.lab4.data.entities.TaskStatus
import com.example.lab4.databinding.FragmentMainBinding
import com.example.lab4.di.ViewModelFactory
import com.example.lab4.di.appComponent
import com.example.lab4.presenter.recycler.TaskAdapter
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding(
        FragmentMainBinding::bind
    )

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: TaskViewModel by viewModels {
        viewModelFactory
    }

    private var adapter: TaskAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TaskAdapter(
            onTaskClick = { task ->
                val action = MainFragmentDirections.actionMainFragmentToCreateFragment(task.id)
                findNavController().navigate(action)
            },
            onChangeStatus = { task ->
                val newStatus = when (task.status) {
                    TaskStatus.TODO -> TaskStatus.IN_PROGRESS
                    TaskStatus.IN_PROGRESS -> TaskStatus.DONE
                    TaskStatus.DONE -> TaskStatus.TODO
                }

                viewModel.save(task.copy(status = newStatus))
            },
            onDeleteClick = { task ->
                viewModel.delete(task)
            }
        )

        with(binding.rvTasks) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainFragment.adapter
        }

        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            adapter?.submitList(tasks)
        }

        binding.buttonNavToCreate.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToCreateFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter = null
    }
}