package com.lyadsky.nolimits4webapp.features.tasks.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.data.AppDatabaseRepostitory
import com.lyadsky.nolimits4webapp.features.tasks.state.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent


enum class TaskType{
    Unspecified,
    Alphaber,
    Logic,
    Numbers,
    Figures,
    Math,
    Colors
}

interface TaskViewModel : KmpViewModel, SubScreenViewModel {

    val state: StateFlow<TaskState>
    fun onBackClick()
    fun onNextClick(isCorrect: Boolean = false)
    fun onBackAction()
    fun onFinishTask()

}

class TaskViewModelImpl(
    override val navigator: Navigator,
    private val dao: AppDatabaseRepostitory
) : KoinComponent, KmpViewModelImpl(), TaskViewModel {
    private val _state = MutableStateFlow(TaskState())
    override val state: StateFlow<TaskState> = _state.asStateFlow()

    override fun onBackClick() {
        navigator.navigateBack()
    }

    override fun onNextClick(isCorrect: Boolean) {
        if (_state.value.stage < 3)
            _state.update { it.copy(stage = _state.value.stage + 1) }
        else {
            jobs.add(
                scope.launch {
                    val stats = dao.getStats()


                })
            navigator.navigateToMain(true)
        }
    }

    override fun onBackAction() {
        if (_state.value.stage > 1)
            _state.update { it.copy(stage = _state.value.stage - 1) }
        else
            navigator.navigateBack()
    }

    override fun onFinishTask() {
        navigator.navigateToFinishTask()
    }
}

