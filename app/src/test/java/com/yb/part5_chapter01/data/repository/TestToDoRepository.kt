package com.yb.part5_chapter01.data.repository

import com.yb.part5_chapter01.data.entity.ToDoEntity

class TestToDoRepository: ToDoRepository {

    private val toDoList: MutableList<ToDoEntity> = mutableListOf()

    override suspend fun getTodoList(): List<ToDoEntity> {
        return toDoList
    }


    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        this.toDoList.addAll(toDoList)
    }
}