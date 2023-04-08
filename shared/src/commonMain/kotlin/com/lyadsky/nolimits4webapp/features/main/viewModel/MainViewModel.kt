package com.lyadsky.nolimits4webapp.features.main.viewModel

import com.lyadsky.nolimits4webapp.common.viewModel.StatefulKmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import com.lyadsky.nolimits4webapp.features.main.state.MainState
import kotlinx.coroutines.flow.StateFlow

interface MainViewModel : StatefulKmpViewModel<MainState>, SubScreenViewModel {

    override val state: StateFlow<MainState>


}

