package com.xcelk.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(val dao: TaskDao): ViewModel() {
    var newTaskName = ""
    val tasks = dao.getAll()


    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }


}