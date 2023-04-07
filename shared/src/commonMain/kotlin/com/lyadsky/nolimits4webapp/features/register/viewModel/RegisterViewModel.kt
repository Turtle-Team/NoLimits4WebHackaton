package com.lyadsky.nolimits4webapp.features.register.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface RegisterViewModel : KmpViewModel, SubScreenViewModel {
    fun onNextClick()
}

class RegisterViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), RegisterViewModel {

    override fun onNextClick() {
        navigator.navigateToInfoUser()
    }
}

