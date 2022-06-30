package com.yb.part5_chapter01.presentation.list

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yb.part5_chapter01.data.entity.ToDoEntity
import com.yb.part5_chapter01.domain.todo.GetToDoListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
필요한 UseCase
1. GetToDoListUseCase
2. UpdateToDoUseCase
3. DeleteAllToDoItemUseCase
 */

internal class ListViewModel(
    private val getToDoListUseCase: GetToDoListUseCase,
) : ViewModel() {
    private var _toDoListLiveData = MutableLiveData<List<ToDoEntity>>()
    val toDoListLiveData: LiveData<List<ToDoEntity>> = _toDoListLiveData

    @SuppressLint("NullSafeMutableLiveData")
    fun fetchData():Job = viewModelScope.launch {
        _toDoListLiveData.postValue(getToDoListUseCase())

    }
}