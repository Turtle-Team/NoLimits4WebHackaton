package com.lyadsky.nolimits4webapp.features.main.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.StatefulKmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.features.main.state.MainState
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent

interface MainViewModel : KmpViewModel, SubScreenViewModel {
    fun onAlphabetClick()
    fun onLogicClick()
    fun onShapeClick()
    fun onMathematicClick()
    fun onNumberClick()
}

class MainViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), MainViewModel {

    override fun onAlphabetClick() {
        navigator.navigateToAlphabet()
    }

    override fun onLogicClick() {
        navigator.navigateToLogic()
    }

    override fun onShapeClick() {
        navigator.navigateToShapes()
    }

    override fun onMathematicClick() {
        navigator.navigateToMathematic()
    }

    override fun onNumberClick() {
        navigator.navigateToNumbers()
    }
}

