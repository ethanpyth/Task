package com.xcelk.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TasksViewModelFactory(private val dao: TaskDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            return TaskViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}