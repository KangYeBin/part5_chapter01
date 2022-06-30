package com.yb.part5_chapter01.domain.todo

import com.yb.part5_chapter01.data.entity.ToDoEntity
import com.yb.part5_chapter01.data.repository.ToDoRepository
import com.yb.part5_chapter01.domain.UseCase

internal class GetToDoListUseCase(
    private val toDoRepository: ToDoRepository
) : UseCase {

    suspend operator fun invoke(): List<ToDoEntity> {
        return toDoRepository.getToDoList()
    }
}