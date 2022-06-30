package com.yb.part5_chapter01.viewmodel.todo

import com.yb.part5_chapter01.ViewModelTest
import com.yb.part5_chapter01.data.entity.ToDoEntity
import com.yb.part5_chapter01.domain.todo.InsertToDoListUseCase
import com.yb.part5_chapter01.presentation.list.ListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.inject

/**
ListViewModel을 테스트하기 위한 Unit Test Class

1. initData()
2. test viewModel Fetch
3. test Item Update
4. test Item Delete All

 */

@ExperimentalCoroutinesApi
internal class ListViewModelTest : ViewModelTest() {

    private val viewModel: ListViewModel by inject()

    private val insertToDoListUseCase: InsertToDoListUseCase by inject()

    private val mockList = (0 until 10).map {
        ToDoEntity(
            id = it.toLong(),
            title = "title $it",
            description = "description $it",
            hasCompleted = false
        )
    }

    /*
    필요한 UseCase
    1. InsertToDoListUseCase
    2. GetToDoItemUseCase
     */

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoListUseCase.invoke(mockList)
    }

    // Test 입력된 데이터를 불러와서 검증한다
    @Test
    fun `test viewModel Fetch`(): Unit = runBlockingTest {
        val testObservable = viewModel.toDoListLiveData.test()

        viewModel.fetchData()
        testObservable.assertValueSequence(
            listOf(mockList)
        )


    }

}