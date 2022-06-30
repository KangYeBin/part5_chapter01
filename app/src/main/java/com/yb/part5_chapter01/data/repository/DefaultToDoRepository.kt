package com.yb.part5_chapter01.data.repository

import com.yb.part5_chapter01.data.entity.ToDoEntity

class DefaultToDoRepository: ToDoRepository {
    override suspend fun getTodoList(): List<ToDoEntity> {
        TODO("Not yet implemented")
    }


    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        TODO("Not yet implemented")
    }
}