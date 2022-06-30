package com.yb.part5_chapter01.di

import com.yb.part5_chapter01.data.repository.TestToDoRepository
import com.yb.part5_chapter01.data.repository.ToDoRepository
import com.yb.part5_chapter01.domain.todo.GetToDoListUseCase
import com.yb.part5_chapter01.domain.todo.InsertToDoListUseCase
import com.yb.part5_chapter01.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    //ViewModel
    viewModel { ListViewModel(get()) }

    // UseCase
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }

    // Repository
    single<ToDoRepository> { TestToDoRepository() }
}