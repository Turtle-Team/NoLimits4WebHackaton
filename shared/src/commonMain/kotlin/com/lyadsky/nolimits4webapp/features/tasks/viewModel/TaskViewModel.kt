package com.lyadsky.nolimits4webapp.features.tasks.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface TaskViewModel : KmpViewModel, SubScreenViewModel {
    fun onBackClick()
}

class TaskViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), TaskViewModel {

    override fun onBackClick() {
        navigator.navigateBack()
    }
}

