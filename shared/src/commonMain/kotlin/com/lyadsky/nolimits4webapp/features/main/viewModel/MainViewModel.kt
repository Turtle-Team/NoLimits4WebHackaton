package com.lyadsky.nolimits4webapp.features.main.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.StatefulKmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.features.main.state.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface MainViewModel : StatefulKmpViewModel<MainState>, SubScreenViewModel {

    fun navigateToHelicGame()
}

class MainViewModelImpl(override val navigator: Navigator) : MainViewModel, KmpViewModelImpl() {

    private val _state = MutableStateFlow(MainState())
    override val state: StateFlow<MainState>
        get() = _state.asStateFlow()


    override fun navigateToHelicGame() {
        navigator.navigateToHelicGame()
    }
}