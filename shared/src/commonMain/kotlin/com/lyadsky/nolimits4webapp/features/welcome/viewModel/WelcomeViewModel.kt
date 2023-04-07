package com.lyadsky.nolimits4webapp.features.welcome.viewModel

import com.lyadsky.nolimits4webapp.common.navigation.Navigator
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModel
import com.lyadsky.nolimits4webapp.common.viewModel.KmpViewModelImpl
import com.lyadsky.nolimits4webapp.common.viewModel.SubScreenViewModel
import org.koin.core.component.KoinComponent

interface WelcomeViewModel : KmpViewModel, SubScreenViewModel {
    fun onRegisterClick()
    fun onAuthClick()
}

class WelcomeViewModelImpl(
    override val navigator: Navigator
) : KoinComponent, KmpViewModelImpl(), WelcomeViewModel {

    override fun onRegisterClick() {
        navigator.navigateToRegister()
    }

    override fun onAuthClick() {
        navigator.navigateToAuth()
    }
}

